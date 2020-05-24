package thrift.f;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class MyFThriftClient {

    public static void main(String[] args) {
        TTransport transport = new TFastFramedTransport(
                new TSocket("localhost", 8899), 2000);

        TProtocol protocol = new TCompactProtocol(transport);

        PersonService.Client client = new PersonService.Client(protocol);

        try{
            transport.open();
            Person person = client.getPersonByName("quandan");

            System.out.println(person);

            System.out.println("-------");

            person.setAge(33);
            person.setMarried(true);
            person.setName("qdqd");

            client.addPerson(person);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transport.close();
        }
    }
}
