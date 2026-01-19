# Types of DI

1. Field based autowiring/ Field injection 

```
@Autowired
private DB db;
```

2. Constructor injection

```
@Service
public class DBService{
	private final DB db;
	public DBService(DB db){
		this.db=db;
	}			
```

```
@Service
@RequiredArgsConstructor
public class DBService {
    private final DB db;
}
```



3. Setter Based Autowiring

Great for optional dependencies

```
@Autowired
public void setGame(Game game){
    this.game=game;
}
```

see lombak