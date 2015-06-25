/* THIS FILE IS GENERATED, DO NOT EDIT, IT WILL BE OVERWRITTEN */
package org.jgrasstools.wps.n52; 
 
import java.util.Collection; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.List; 
import java.io.*; 
 
import oms3.Access; 
import oms3.ComponentAccess; 
import oms3.annotations.Execute; 
import oms3.annotations.Finalize; 
import oms3.annotations.Initialize; 
 
import org.n52.wps.server.AbstractAnnotatedAlgorithm;
import org.n52.wps.algorithm.annotation.*; 
 
import org.n52.wps.io.data.binding.literal.*; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
 
import org.geotools.process.ProcessException; 
import org.jgrasstools.modules.Markoutlets; 
 
@Algorithm(version = "1.0.0", abstrakt = "Marks all the outlets of the considered region on the drainage directions map with the conventional value 10.")
public class MarkoutletsAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(MarkoutletsAlgorithm.class); 

  public MarkoutletsAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inflow;

  @LiteralDataInput(identifier = "inFlow", abstrakt = "The map of flowdirections.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlow(String inflow) { 
    this.inflow = inflow;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outflow;

  @LiteralDataInput(identifier = "outFlow", abstrakt = "The map of the flowdirections with outlet marked.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutFlow(String outflow) { 
    this.outflow = outflow;
  }

  private String res_outflow;

  @LiteralDataOutput(identifier = "res_outFlow", abstrakt = "The map of the flowdirections with outlet marked.", binding = LiteralStringBinding.class)
  public String getRes_outFlow() { 
    return res_outflow;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.MarkoutletsAlgorithm");
    
    Markoutlets tmpModule = new Markoutlets(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outFlow",  (String) outflow); 
    logger.info("outFlow " + ( (String) outflow) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.setInputData(inputs, tmpModule, uLog); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.callAnnotated(tmpModule, Initialize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Execute.class, false); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Finalize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    
    // get the results 
    HashMap<String, String> outputs = new HashMap<String, String>();
    ComponentAccess cA = new ComponentAccess(tmpModule); 
    Collection<Access> outputsCollection = cA.outputs(); 
    
    outputs.put("outFlow", "String"); 
    
    res_outflow = (String) outflow; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outFlow")) { 
            // and put them into the output result variables 
            res_outflow = (String) access.getFieldValue(); 
        }
        } 
    
    }

}
