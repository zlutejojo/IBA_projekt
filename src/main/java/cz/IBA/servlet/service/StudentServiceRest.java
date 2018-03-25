package cz.IBA.servlet.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import cz.IBA.servlet.entity.Student;

/**
 * rest pro StudentListImpl
 * po zadání URL http://localhost:port/rest/Student/index, kde index je index studenta v seznamu, se vypíšou informace o studentovi
 * toto @Path("/Student") je relativní k servletu, mapovani servletu mam v tomto pripade nastaveny ve web.xml
 */

@Path("/Student")
public class StudentServiceRest {
    @GET
    @Path("/{param}")
    public Response getInfo(@PathParam("param") int index) {
        StudentServiceListImp studentService = new StudentServiceListImp();
        Student student = studentService.readAll().get(index);
        String output = student.toString();

        return Response.status(200).entity(output).build();
    }
}