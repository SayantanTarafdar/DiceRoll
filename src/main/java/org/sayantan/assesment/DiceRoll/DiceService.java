package org.sayantan.assesment.DiceRoll;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Path("/roll")
@Service
public interface DiceService {
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    Response roll(@Valid @QueryParam("dices") @NotNull @Min(1) Integer numberOfDices,@Valid @QueryParam("sides")@NotNull @Min(4) Integer sides,@Valid @QueryParam("rolls")@NotNull @Min(1) Integer numberOfRolls );
    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    Response query();
}
