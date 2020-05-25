package org.example.f;

import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByName(String name) throws TException {

        Person person = new Person();
        person.setName(name);
        person.setAge(22);
        person.setMarried(false);
        return person;
    }

    @Override
    public void addPerson(Person person) throws TException {
        System.out.println("form client" + person);
    }
}
