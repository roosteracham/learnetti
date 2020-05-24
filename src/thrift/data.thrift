namespace java thrift.f

struct Person{
    1: optional i32 age,
    2: optional string name,
    3: optional bool married
}

service PersonService{
    Person getPersonByName(1: required string name),
    void addPerson(1: required Person person)
}