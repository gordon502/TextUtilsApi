package pl.io.texttransformer.app;

public class Response {

    private final String result;

    public Response(String result) {
        this.result = result;
    }

    /**
     * Public getter for POJO, converting to JSON
     *
     * @return
     */
    public String getResult() {
        return result;
    }
}
