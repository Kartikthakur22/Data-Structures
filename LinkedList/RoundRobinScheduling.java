public class RoundRobinScheduling {
    class Process {
        int processId;
        int burstTime;
        int remainingBurstTime;
        int priority;
        Process next;

        public Process(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.remainingBurstTime = burstTime;
            this.priority = priority;
            this.next = null;
        }
    }

    private Process head;
    private Process tail;

    public RoundRobinScheduling() {
        head = null;
        tail = null;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;

        Process current = head;
        Process prev = null;
        do {
            if (current.processId == processId) {
                if (prev == null) {
                    head = current.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) return;

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int totalProcesses = 0;
        int elapsedTime = 0;

        Process current = head;
        while (current != null) {
            totalProcesses++;
            current = current.next;
            if (current == head) break;
        }

        current = head;
        while (current != null) {
            if (current.remainingBurstTime > 0) {
                int waitingTime = elapsedTime;
                int turnAroundTime = waitingTime + current.burstTime;

                if (current.remainingBurstTime > timeQuantum) {
                    elapsedTime += timeQuantum;
                    current.remainingBurstTime -= timeQuantum;
                } else {
                    elapsedTime += current.remainingBurstTime;
                    current.remainingBurstTime = 0;
                    removeProcess(current.processId);
                }

                totalWaitingTime += waitingTime;
                totalTurnaroundTime += turnAroundTime;

                if (current == head) {
                    break;
                }
                current = current.next;
            } else {
                break;
            }
        }
        System.out.println("Average Waiting Time: " + (float) totalWaitingTime / totalProcesses);
        System.out.println("Average Turnaround Time: " + (float) totalTurnaroundTime / totalProcesses);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }

        Process current = head;
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime +
                    ", Remaining Burst Time: " + current.remainingBurstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        RoundRobinScheduling rrs = new RoundRobinScheduling();

        rrs.addProcess(1, 5, 2);
        rrs.addProcess(2, 10, 1);
        rrs.addProcess(3, 8, 3);
        rrs.addProcess(4, 6, 4);

        System.out.println("Initial Process List:");
        rrs.displayProcesses();

        System.out.println("\nStarting Round Robin Scheduling with Time Quantum of 4:");
        rrs.roundRobinScheduling(4);

        System.out.println("\nFinal Process List after Scheduling:");
        rrs.displayProcesses();
    }
}
