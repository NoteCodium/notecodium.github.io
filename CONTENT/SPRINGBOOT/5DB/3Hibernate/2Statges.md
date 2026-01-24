```
public static void main(String[] args) {
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("MyPersistenceUnit");
    //persistanceUnitName
    //A factory is associated with a particular persistance unit
    //We can have separate persitance units hence factories for different db
    //we write different configuration for each persistance unit   

    EntityManager em=emf.createEntityManager();

    
///////////////////////////////////
    em.getTransaction().begin();
    
    ////////////////////////////////////////////////
    MyAccount account = new MyAccount();
    account.setId(1L );
    account.setName("John Doe");
    account.setAge(25);
    ////////////////////////////////////////////////

    em.persist(account);

    em.getTransaction().commit();

    em.close();
}
```





![image.png](/images/image-343.png)

# Managed state

1. when you select something?

Detaching from persist state

```
em.detach(account)
```



![image.png](/images/image-344.png)

?

