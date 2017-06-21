
package recursos;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * 
 */
@javax.ws.rs.ApplicationPath("/")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(CorsFilter.class);
        addRestResourceClasses(resources);
        
        return resources;
    }


    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(recursos.ClienteRecurso.class);
    }
    
}
