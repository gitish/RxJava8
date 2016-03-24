package com.shl.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.shl.service.MongoConfiguration;

@Path("/rewards")
@Produces(MediaType.APPLICATION_JSON)
public class RewardsResource {
	
	MongoClient mongoClient;
	public RewardsResource(MongoConfiguration c){
		mongoClient = new MongoClient(c.getMongoNode()[0] , c.getMongoPort() );
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createReward(@FormParam("points_to_redeem") String points,
			@FormParam("image_url") String url,
			@FormParam("redeemable") boolean redeemable,
			@FormParam("name") String name) {
		return Response.created(null).build();
	}

	@GET
	@Path("/All")
	public Response getReward() {
		// retrieve information about the reward with the provided id
		MongoDatabase db=mongoClient.getDatabase("quiz");
		MongoCollection<Document> coll= db.getCollection("questions");
		FindIterable<Document> cursor = coll.find();
		String result="";
		MongoCursor<Document> iterator=cursor.iterator();
		
        while (iterator.hasNext()) { 
           Document doc = iterator.next();
           Object obj= doc.get("options");
           result = result + obj;
        }
        
		return Response.ok(result)
				.build();
	}
	
	@GET
	@Path("/{id}")
	public Response getReward(@PathParam("id") int rewardId) {
		// retrieve information about the reward with the provided id
		return Response.ok(
				"{\"points_to_redeem\": 20, \"image_url\": \"http://image.com\", \"id\": "
						+ rewardId
						+ ",\"redeemable\": true, \"name\": \"Dinesh S\" }")
				.build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateReward(@PathParam("id") int rewardId,
			@FormParam("points_to_redeem") String points,
			@FormParam("image_url") String url,
			@FormParam("redeemable") boolean redeemable,
			@FormParam("name") String name) {
		return Response.ok("{\"message\"	:\"done\"}").build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteReward(@PathParam("id") int rewardId) {
		return Response.noContent().build();
	}
}
