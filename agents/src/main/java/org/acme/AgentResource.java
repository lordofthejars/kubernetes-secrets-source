package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.quarkus.vault.VaultKVSecretEngine;

@Path("/agents")
public class AgentResource {

    private static final Log LOG = LogFactory.getLog(AgentResource.class);

    @Inject
    VaultKVSecretEngine kvSecretEngine;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{vault-path}")
    public Response getAgent(@PathParam("vault-path") String vaultPath) {

        ResponseBuilder responseBuilder = null;

        try {
            if ("config".equals(vaultPath.toLowerCase())) {
                responseBuilder = Response.status(404);
            } else {
                responseBuilder = Response.ok(kvSecretEngine.readSecret(vaultPath));
            }
        } catch (Exception e) {
            LOG.error("Error Invoking Vault", e);
            responseBuilder = Response.status(404);
        }

        return responseBuilder.build();

    }
}