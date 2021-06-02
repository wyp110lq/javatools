package gsontest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonTest {

    public static Gson gson = new Gson();

    public static void main(String[] args) {
        String name = "riqi";
        int age = 26;
        Family family = new Family("爸爸", "妈妈");

        // 序列化Map
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("name", name);
        userMap.put("age", age);
        System.out.println(gson.toJson(userMap)); //{"age":26,"name":"riqi"}

        // 序列化List
        List<Object> userList = new ArrayList<Object>();
        userList.add(name);
        userList.add(age);
        System.out.println(gson.toJson(userList)); //["riqi",26]

        // 序列化对象
        System.out.println(gson.toJson(family)); //{"father":"爸爸","mother":"妈妈"}

        // 借助TypeToken泛型实现单个对象序列化和反序列化
        Person person = new Person(name, age, family);
        Type personType = new TypeToken<Person>() {
        }.getType();
        String personJsonTo = gson.toJson(person, personType);
        Person personJsonFrom = gson.fromJson(personJsonTo, personType);
        Family familyJsonFrom = personJsonFrom.getFamily();
        System.out.println(personJsonTo); //{"name":"riqi","age":26,"family":{"father":"爸爸","mother":"妈妈"}}
        System.out.println(personJsonFrom);//Person [name=riqi, age=26, family=Family [father=爸爸, mother=妈妈]]
        System.out.println(familyJsonFrom);//Family [father=爸爸, mother=妈妈]

        // 借助TypeToken泛型实现对象列表序列化和反序列化
        List<Person> personList = new ArrayList<Person>();
        Type personListType = new TypeToken<List<Person>>() {
        }.getType();
        for (int i = 0; i < 2; i++) {
            Person personTmp = new Person(name, age + i, family); // 年龄做了变化
            personList.add(personTmp);
        }
        String personListJsonTo = gson.toJson(personList, personListType);
        List<Person> personListJsonFrom = gson.fromJson(personListJsonTo, personListType);
        System.out.println(personListJsonTo);//[{"name":"riqi","age":26,"family":{"father":"爸爸","mother":"妈妈"}},{"name":"riqi","age":27,"family":{"father":"爸爸","mother":"妈妈"}}]
        System.out.println(personListJsonFrom);//[Person [name=riqi, age=26, family=Family [father=爸爸, mother=妈妈]], Person [name=riqi, age=27, family=Family [father=爸爸, mother=妈妈]]]
    }
}