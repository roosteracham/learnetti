package pb.f;

public class PBTest {

    public static void main(String[] args) throws Exception{
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
                .setEmail("abc@123.com").setId(1).setName("quanDan").build();

        byte[] bytes = person.toByteArray();

        AddressBookProtos.Person person1 = AddressBookProtos.Person.parseFrom(bytes);

        System.out.println(person1.toString());
    }
}
