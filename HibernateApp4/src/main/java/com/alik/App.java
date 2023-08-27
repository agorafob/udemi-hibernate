package com.alik;

import com.alik.model.Item;
import com.alik.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().
                addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            //get list of items from person
//            Person person = session.get(Person.class,3);
//            System.out.println(person);
//            List<Item> itemList = person.getItems();
//            System.out.println(itemList);

            //get owner of item
//            Item item = session.get(Item.class,5);
//            System.out.println(item);
//            System.out.println(item.getOwner());

            //add new item to person
//            Person person = session.get(Person.class,2);
//            Item item = new Item("Item from Hibernate",person);
            //this add is only for hibernate cash
//            person.getItems().add(item);
            // real add to db
//            session.persist(item);

            //add new person with new item
//            Person person = new Person("Test person", 30);
//            Item newItem = new Item("test item", person);
                // add list of items to person
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
            // так как не настроено каскадирование нужно сохранять оба объекта иначе выдаст ошибку,
            // что содержащийся внутри объекта другой объект не сохранен
//            session.persist(person);
//            session.persist(newItem);

            // delete all persons items
//            Person person = session.get(Person.class,3);
            //delete from db
//            List<Item> itemList = person.getItems();
//            for (Item i :itemList) {
//                session.remove(i);
//            }
            //delete from cash
//            person.getItems().clear();

            // delete person from db ,
            // так как в бд стоит настройка при удалении ставить null то очистит автоматом
            //Person person = session.get(Person.class,2);
            //session.remove(person);
            // в кеше ставим null тоже
            //person.getItems().forEach(i->i.setOwner(null));


            // update items owner
            Person person = session.get(Person.class,4);
            Item item = session.get(Item.class,1);
            //clear in cash old owners item
            item.getOwner().getItems().remove(item);
            //add in db new owner
            item.setOwner(person);
            //add in cash new owner
            person.getItems().add(item);





            session.getTransaction().commit();

        }


    }
}
