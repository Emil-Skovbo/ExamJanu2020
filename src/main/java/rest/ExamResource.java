package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Delivery;
import entities.Truck;
import utils.EMF_Creator;
import facades.MultiFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("exam")
public class ExamResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/startcode",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final MultiFacade FACADE = MultiFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getDriverCount() {
        long count = FACADE.getDriverCount();
        return "{\"count\":" + count + "}";  //Done manually so no need for a DTO
    }

    @Path("Truck")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getDriver() {
        long count = FACADE.getTruckAmount();
        return "{\"count\":" + count + "}";  //Done manually so no need for a DTO
    }

    @Path("alltrucks")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllTrucks() {
        List<Truck> p = FACADE.getAllTrucks();
        return GSON.toJson(p);
    }

//    @Path("/get/phone{phone}")
//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public String getPersonByPhone(@PathParam("phone") int phone) {
//        Person p = FACADE.getPersonByPhone(phone);
//        return GSON.toJson(FACADE.makeDTO(p.getId()));
//    }
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getDeliverybyId(@PathParam("id") int id) {
        Delivery delivery = FACADE.getDeloveryById(id);
        return GSON.toJson(delivery);
    }

    @Path("/insertdata")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String insertData() {
        FACADE.insertData();
        return "{\"msg\":\"Done\"}";

    }

//    @Path("/get/{city}")
//        @GET
//        @Produces({MediaType.APPLICATION_JSON})
//        public String getPersonByCity(@PathParam("city") String city) {
//        List<Person> p = FACADE.getAllPersonsFromCity(city);
//        return GSON.toJson(MakePersonDTOList(p));
//    }
//
//    @Path("/get/all/{hobbie}")
//        @GET
//        @Produces({MediaType.APPLICATION_JSON})
//        @Operation(summary = "Get a person by hobby",
//                tags = {"persons"},
//                responses = {
//                    @ApiResponse(
//                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class))),
//                    @ApiResponse(responseCode = "200", description = "All persons"),
//                    @ApiResponse(responseCode = "404", description = "Persons not found")})
//        public String getPersonByHobby(@PathParam("hobbie") String hobbie) {
//        List<Person> p = FACADE.getPersonsWithSameHobby(hobbie);
//        return GSON.toJson(MakePersonDTOList(p));
//    }
//
//    @Path("/get/count/{hobbie}")
//        @GET
//        @Produces({MediaType.APPLICATION_JSON})
//        @Operation(summary = "Get hobby count",
//                tags = {"persons"},
//                responses = {
//                    @ApiResponse(
//                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class))),
//                    @ApiResponse(responseCode = "200", description = "All persons"),
//                    @ApiResponse(responseCode = "404", description = "Persons not found")})
//        public String getHobbyCount(@PathParam("hobbie") String hobbie) {
//        int p = FACADE.getSpecificHobbyCount(hobbie);
//
//        return GSON.toJson("count : " + p);
//    }
//
//    @PUT
//        @Consumes(MediaType.APPLICATION_JSON)
//        @Produces(MediaType.APPLICATION_JSON)
//        @Path("{id}")
//        @Operation(summary = "Get person by id",
//                tags = {"persons"},
//                responses = {
//                    @ApiResponse(
//                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class))),
//                    @ApiResponse(responseCode = "200", description = "All persons"),
//                    @ApiResponse(responseCode = "404", description = "Persons not found")})
//        public String editPerson(String personAsJson, @PathParam("id") int id) {
//
//        Person pOrignal = FACADE.getPersonByID(id);
//        Person NewPersonVal = GSON.fromJson(personAsJson, Person
//
//.class  
//
//
//);
//        pOrignal.setFirstName(NewPersonVal.getFirstName());
//        //pOrignal.setPhone(NewPersonVal.getPhone());
//        pOrignal.setAddress(NewPersonVal.getAddress());
//
//        // makes that the value return is on a good json format
//        return GSON.toJson(pOrignal);
//    }
//
//    @POST
//        @Consumes(MediaType.APPLICATION_JSON)
//        @Produces(MediaType.APPLICATION_JSON)
//        @Operation(summary = "Add a person",
//                tags = {"persons"},
//                responses = {
//                    @ApiResponse(
//                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class))),
//                    @ApiResponse(responseCode = "200", description = "All persons"),
//                    @ApiResponse(responseCode = "404", description = "Persons not found")})
//        public String addPerson(String personAsJson) {
//        PersonDTO personNew = GSON.fromJson(personAsJson, PersonDTO
//
//.class  
//
//
//);
//        PersonDTO p = FACADE.addPerson(personNew);
//        return GSON.toJson(p);
//    }
//
//    //Delete er ikke testet endnu - 
//    @DELETE
//        @Produces({MediaType.APPLICATION_JSON})
//        @Consumes({MediaType.APPLICATION_JSON})
//        @Path("{id}")
//        @Operation(summary = "Delete a person",
//                tags = {"persons"},
//                responses = {
//                    @ApiResponse(
//                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDTO.class))),
//                    @ApiResponse(responseCode = "200", description = "All persons"),
//                    @ApiResponse(responseCode = "404", description = "Persons not found")})
//        public String deletePerson(@PathParam("id") int id) {
//        Person p = FACADE.getPersonByID(id);
//        int id1 = p.getId();
//        FACADE.deletePerson(id1);
//        return "{}";
//    }
}
