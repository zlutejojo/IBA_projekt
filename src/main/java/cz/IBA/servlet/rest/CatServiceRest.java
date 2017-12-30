package cz.IBA.servlet.rest;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;
import com.sun.tools.classfile.Dependencies;

public class CatServiceRest {

    public static String getCatName
            (RestTemplate restTemplate) {
        Cat cat = restTemplate.postForObject("url",
                null,
                Cat.class
        );

        String catName = cat.getName();

        return catName;

    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(getCatName(restTemplate));

//        Dependency[] dependencies = restTemplate
//                .getForObject(
//                        "https://javalibs.com/search/autocomplete/everything?term=okhttp",
//                        Dependency[].class);
//        Arrays.stream(dependencies)
//                .forEach(System.out::println);

//        String javalibs = restTemplate
//                .getForObject(
//                        "https://javalibs.com/",
//                        String.class);
//        System.out.println(javalibs);
    }

}

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Response;

//@Path("/Student")
//public class CatServiceRest {
//    @GET
//    @Path("/{param}")
//    public Response getMsg(@PathParam("param") String msg) {
//
//        String output = "Jersey say : " + msg;
//
//        return Response.status(200).entity(output).build();
//
//    }
//
//
//}



