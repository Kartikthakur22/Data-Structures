import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SocialMediaSystem {
    class User {
        int userId;
        String name;
        int age;
        LinkedList<Integer> friends;
        User next;

        public User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = new LinkedList<>();
            this.next = null;
        }
    }

    private User head;

    public SocialMediaSystem() {
        head = null;
    }

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    public User searchUserById(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public User searchUserByName(String name) {
        User current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);

        if (user1 != null && user2 != null && user1 != user2) {
            if (!user1.friends.contains(userId2)) {
                user1.friends.add(userId2);
            }
            if (!user2.friends.contains(userId1)) {
                user2.friends.add(userId1);
            }
        }
    }

    public void removeFriend(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.friends.remove(Integer.valueOf(userId2));
            user2.friends.remove(Integer.valueOf(userId1));
        }
    }

    public List<Integer> findMutualFriends(int userId1, int userId2) {
        User user1 = searchUserById(userId1);
        User user2 = searchUserById(userId2);

        List<Integer> mutualFriends = new ArrayList<>();
        if (user1 != null && user2 != null) {
            for (int friendId1 : user1.friends) {
                if (user2.friends.contains(friendId1)) {
                    mutualFriends.add(friendId1);
                }
            }
        }
        return mutualFriends;
    }

    public void displayFriends(int userId) {
        User user = searchUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friends);
        } else {
            System.out.println("User not found.");
        }
    }

    public void countFriends() {
        User current = head;
        while (current != null) {
            System.out.println("User " + current.name + " has " + current.friends.size() + " friends.");
            current = current.next;
        }
    }

    public void displayAllUsers() {
        User current = head;
        while (current != null) {
            System.out.println("User ID: " + current.userId + ", Name: " + current.name + ", Age: " + current.age);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaSystem sms = new SocialMediaSystem();

        sms.addUser(1, "Alice", 25);
        sms.addUser(2, "Bob", 30);
        sms.addUser(3, "Charlie", 28);
        sms.addUser(4, "David", 22);

        sms.addFriend(1, 2);
        sms.addFriend(1, 3);
        sms.addFriend(2, 3);
        sms.addFriend(2, 4);

        sms.displayFriends(1);  // Alice's friends
        sms.displayFriends(2);  // Bob's friends
        sms.displayFriends(3);  // Charlie's friends

        System.out.println("\nMutual Friends between Alice and Bob:");
        List<Integer> mutual = sms.findMutualFriends(1, 2);
        System.out.println(mutual);

        System.out.println("\nCounting the number of friends for each user:");
        sms.countFriends();

        System.out.println("\nDisplaying all users:");
        sms.displayAllUsers();

        sms.removeFriend(1, 3);
        System.out.println("\nAfter removing the friendship between Alice and Charlie:");
        sms.displayFriends(1);  // Alice's friends
        sms.displayFriends(3);  // Charlie's friends
    }
}
