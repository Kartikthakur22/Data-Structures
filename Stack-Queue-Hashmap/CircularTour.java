import java.util.LinkedList;
import java.util.Queue;

class CircularTour {
    
    static class PetrolPump {
        int petrol;
        int distance;
        
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
    
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        Queue<Integer> queue = new LinkedList<>();
        int totalSurplus = 0;
        int currentSurplus = 0;

        for (int i = 0; i < n; i++) {
            queue.add(i);
            totalSurplus += pumps[i].petrol - pumps[i].distance;
            currentSurplus += pumps[i].petrol - pumps[i].distance;
            
            if (currentSurplus < 0) {
                queue.poll();
                currentSurplus = 0;
            }
        }

        if (totalSurplus < 0) {
            return -1;
        }

        return queue.peek();
    }
    
    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5),
            new PetrolPump(5, 7)
        };
        
        int startPoint = findStartingPoint(pumps);
        
        if (startPoint == -1) {
            System.out.println("It's not possible to complete the circular tour.");
        } else {
            System.out.println("The tour can be started at pump index: " + startPoint);
        }
    }
}
