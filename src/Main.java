import com.fasterxml.jackson.databind.ObjectMapper;
import mappingclass.MappingClass;
import mappingclass.MappingClassOutput;
import handler.Handler;

import java.io.File;
import java.io.FileWriter;

public final class Main {

    private Main() { }

    /**
     * @param args input and output files
     * @throws Exception file not found
     */
    public static void main(final String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        File in = new File(args[0]);
        FileWriter out = new FileWriter(args[1]);

        MappingClass mc = objectMapper.readValue(in, MappingClass.class);
        Handler h = new Handler(mc);
        MappingClassOutput mco = h.getResult();

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(out, mco);
    }
}
