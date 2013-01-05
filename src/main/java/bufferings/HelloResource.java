package bufferings;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.view.Viewable;

@Path("/hello")
public class HelloResource {

  @GET
  @Path("/{n}")
  @Produces(MediaType.TEXT_HTML)
  public Viewable sayHello(@PathParam("n") String name) {
    return new Viewable("sample", "Hello " + name + "!");
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public Viewable sayHello2() {
    return new Viewable("sample2",
        new SampleModel("Good morning", "my friends"));
  }

  public static class SampleModel {
    public String greeting;
    public String name;

    public SampleModel(String greeting, String name) {
      this.greeting = greeting;
      this.name = name;
    }
  }
}
