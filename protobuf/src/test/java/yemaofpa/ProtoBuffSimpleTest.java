package yemaofpa;

import com.example.tutorial.AddressBookProtos.AddressBook;
import com.example.tutorial.AddressBookProtos.Person;

import com.example.tutorial.ExtraInfoProtos;
import com.google.protobuf.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class ProtoBuffSimpleTest {

    // This function fills in a Person message based on user input.
    private static Person promptForAddress(int id, String name, String email, String number, String type) throws IOException {
        Person.Builder person = Person.newBuilder();

        person.setId(id);

        person.setName(name);

        if (email.length() > 0) {
            person.setEmail(email);
        }

        Person.PhoneNumber.Builder phoneNumber =
                Person.PhoneNumber.newBuilder().setNumber(number);

        switch (type) {
            case "mobile":
                phoneNumber.setType(Person.PhoneType.MOBILE);
                break;
            case "home":
                phoneNumber.setType(Person.PhoneType.HOME);
                break;
            case "work":
                phoneNumber.setType(Person.PhoneType.WORK);
                break;
            default:
                System.out.println("Unknown phone type.  Using default.");
                break;
        }

        person.addPhones(phoneNumber);

        return person.build();
    }

    public static void main(String[] args) throws Exception {

        // Main function:  Reads the entire address book from a file,
        //   adds one person based on user input, then writes it back out to the same
        //   file.

        AddressBook.Builder builder = AddressBook.newBuilder();

        // Read the existing address book.
//        try {
//            builder.mergeFrom(new FileInputStream(args[0]));
//        } catch (FileNotFoundException e) {
//            System.out.println(args[0] + ": File not found.  Creating a new file.");
//        }

        // Add an address.
        builder.addPeople(promptForAddress(99, "Foo", "2744@qq.com", "28006", "work"));

        // Write the new address book back to disk.
        ByteArrayOutputStream output = new ByteArrayOutputStream(1024*10);
        AddressBook addressBook = builder.build();
        addressBook.writeTo(output);
        System.out.println(output.toString());
        output.close();

        byte[] bytes = addressBook.toByteArray();
        AddressBook addressBook2 = AddressBook.parseFrom(bytes);
        System.out.println(addressBook2.toString());

        ExtraInfoProtos.ExtraInfo.Builder extraInfoBuilder = ExtraInfoProtos.ExtraInfo.newBuilder();
        extraInfoBuilder.putValues("foo", "bar");
        extraInfoBuilder.putAllValues(null);
        ExtraInfoProtos.ExtraInfo extraInfo = extraInfoBuilder.build();

        Map<String, String> map = new HashMap<>();
        map.put("foo1", "bar1");
        map.put("foo2", "bar2");

        MapEntryLite mapEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");
//        mapEntry.
    }

    private static <K, V> void serializeMapTo(CodedOutputStream out, Map<K, V> m, MapEntry<K, V> defaultEntry,
                                              int fieldNumber) throws IOException {
        for (Map.Entry<K, V> entry : m.entrySet()) {
            out.writeMessage(fieldNumber,
                    defaultEntry.newBuilderForType()
                            .setKey(entry.getKey())
                            .setValue(entry.getValue())
                            .build());
        }
    }

}
