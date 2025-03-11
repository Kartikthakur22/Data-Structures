class TextEditor {
    class TextState {
        String text;
        TextState prev;
        TextState next;

        public TextState(String text) {
            this.text = text;
            this.prev = null;
            this.next = null;
        }
    }

    private TextState currentState;
    private TextState head;
    private TextState tail;
    private int historySize;
    private int currentSize;

    public TextEditor(int historySize) {
        this.historySize = historySize;
        this.currentSize = 0;
        this.head = this.tail = this.currentState = null;
    }

    public void addTextState(String newText) {
        TextState newState = new TextState(newText);

        if (currentState != null) {
            currentState.next = null;
        }

        if (currentState == null) {
            head = tail = currentState = newState;
        } else {
            currentState.next = newState;
            newState.prev = currentState;
            currentState = newState;
            tail = currentState;
        }

        if (currentSize >= historySize) {
            head = head.next;
            head.prev = null;
        } else {
            currentSize++;
        }
    }

    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.text);
        } else {
            System.out.println("No more undo history.");
        }
    }

    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.text);
        } else {
            System.out.println("No more redo history.");
        }
    }

    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current Text: " + currentState.text);
        } else {
            System.out.println("No text available.");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        editor.addTextState("Hello");
        editor.displayCurrentState();

        editor.addTextState("Hello World");
        editor.displayCurrentState();

        editor.addTextState("Hello World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addTextState("Hello World!!");
        editor.displayCurrentState();

        editor.undo();
        editor.undo();
        editor.undo();
    }
}
