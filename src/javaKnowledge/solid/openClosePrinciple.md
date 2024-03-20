
```
public class VIPCenter {
    void serviceVIP(T extend User user>) {
        if (user instanceof SlumDogVIP) {
            // 穷X VIP，活动抢的那种
            // do somthing
        } else if (user instanceof RealVIP) {
            // do somthing } // ... }
        }
    }
}

public class VIPCenter {
    private Map providers;
    void serviceVIP(T extend User user） {
        providers.get(user.getType()).service(user);
    }
}
interface ServiceProvider {
    void service(T extend User user) ;
}
class SlumDogVIPServiceProvider implements ServiceProvider{
    void service(T extend User user){
        // do somthing
        }
}
class RealVIPServiceProvider implements ServiceProvider{
    void service(T extend User user) {
        // do something
        }
    }
}
```