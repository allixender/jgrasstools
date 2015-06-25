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
import org.jgrasstools.modules.DistanceToOutlet; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculates the projection on the plane of the distance of each pixel from the outlet.")
public class DistanceToOutletAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(DistanceToOutletAlgorithm.class); 

  public DistanceToOutletAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inpit;

  @LiteralDataInput(identifier = "inPit", abstrakt = "The map of depitted elevation, if it's null the models work in 2d mode.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinPit(String inpit) { 
    this.inpit = inpit;
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

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pmode;

  @LiteralDataInput(identifier = "pMode", abstrakt = "Processing mode, 0= simple mode in meter, 1 = topological distance.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpMode(int pmode) { 
    this.pmode = pmode;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outdistance;

  @LiteralDataInput(identifier = "outDistance", abstrakt = "The map of the distance to the outlet.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutDistance(String outdistance) { 
    this.outdistance = outdistance;
  }

  private String res_outdistance;

  @LiteralDataOutput(identifier = "res_outDistance", abstrakt = "The map of the distance to the outlet.", binding = LiteralStringBinding.class)
  public String getRes_outDistance() { 
    return res_outdistance;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.DistanceToOutletAlgorithm");
    
    DistanceToOutlet tmpModule = new DistanceToOutlet(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pMode",  (int) pmode); 
    logger.info("pMode " + ( (int) pmode) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("outDistance",  (String) outdistance); 
    logger.info("outDistance " + ( (String) outdistance) );
    inputs.put("inPit",  (String) inpit); 
    logger.info("inPit " + ( (String) inpit) );
    
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
    
    outputs.put("outDistance", "String"); 
    
    res_outdistance = (String) outdistance; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outDistance")) { 
            // and put them into the output result variables 
            res_outdistance = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

