// DBMS Lab Exp No.12 :- Database Connectivity using Java and MongoDB

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.*;
public class JavaMongoDBConnection {
public static void main(String[] args) {
    MongoClientURI uri = new
    MongoClientURI("mongodb://localhost:27017");
    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("DB");
    MongoCollection <Document> collection = database.getCollection("Student");
    Scanner sc=new Scanner(System.in);
    int ch,rno,mob,ch1;
    String name;
    do {
            System.out.println("1.Insert\n2.Read\n3.Update\n4.Delete\n5.Exit\n");
            System.out.print("Enter your choice:")
            ch = sc.nextInt();
            switch(ch) {
            case 1:
                System.out.println("\nEnter roll no name and mob no to insert:\n");
                rno=sc.nextInt();
                name=sc.next();
                mob=sc.nextInt();
                Document student = new Document("name", name).append("rollno", rno).append("mobno", mob);
                collection.insertOne(student);
                System.out.println("Student inserted: " + student.toJson());
                break;
            case 2:
                System.out.println("\nEnter the Roll no to read:");
                rno = sc.nextInt();
                Document foundStudent = collection.find(Filters.eq("rollno", rno)).first();
                System.out.println("Found student: " + foundStudent.toJson());
                break;
            case 3:
                System.out.println("\nEnter Roll no to update:");
                rno = sc.nextInt();
                System.out.println("Enter choice to be updated 1.Rollno 2.name and 3.mob no");
                ch1=sc.nextInt();
            switch(ch1) {
                case 1:
                System.out.println("Enter Roll no to update:");
                rno = sc.nextInt();
                collection.updateOne(Filters.eq("rollno", rno), new Document("$set", new Document("rollno", rno)));
                System.out.println("Student Roll no updated");
                break;
            case 2:
                System.out.println("Enter name to update:");
                name = sc.next();
                collection.updateOne(Filters.eq("rollno", rno), new Document("$set", new Document("name", name)));
                System.out.println("Student name updated");
                break;
            case 3:
                System.out.println("Enter Mob no to update:");
                mob = sc.nextInt();
                collection.updateOne(Filters.eq("rollno", rno), new Document("$set", new Document("mobno", mob)));
                System.out.println("Student mob noupdated");
                break;
            }
            break;
            case 4:
                System.out.println("\nEnter Roll no to delete:");
                rno = sc.nextInt();
                collection.deleteOne(Filters.eq("rollno", rno));
                System.out.println("Student deleted");
            }
        } while(ch<=4);
        mongoClient.close();
    }
}

/*
OUTPUT:-
1.Insert
2.Read
3.Update
4.Delete
5.Exit
Enter your choice: 1
Enter roll no name and mob no to insert:
77
Vaibhavi
46791352
Student inserted: { "_id" : { "$oid" : "653d4bfaafd79861a4ac370a" }, "name" :
"Vaibhavi", "rollno" : 77, "mobno" : 46791352 }
1.Insert
2.Read
3.Update
4.Delete
5.Exit
Enter your choice:2
Enter the Roll no to read:
79
Found student: { "_id" : { "$oid" : "653d1cb4cb775b0626daf63b" }, "name" :
"Rutuja", "rollno" : 79, "mobno" : 78984565 }
1.Insert
2.Read
3.Update
4.Delete
5.Exit
Enter your choice:3
Enter Roll no to update:
79
Enter choice to be updated 1.Rollno 2.name and 3.mob no
3
Enter Mob no to update:
98765432
Student mob noupdated
1.Insert
2.Read
3.Update
4.Delete
5.Exit
Enter your choice:4
Enter Roll no to delete:
79
Student deleted
1.Insert
2.Read
3.Update
4.Delete
5.Exit
Enter your choice:
5
*/
