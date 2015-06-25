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
import org.jgrasstools.modules.Morpher; 
 
@Algorithm(version = "1.0.0", abstrakt = "Mophologic binary operations")
public class MorpherAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(MorpherAlgorithm.class); 

  public MorpherAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap;

  @LiteralDataInput(identifier = "inMap", abstrakt = "The map to morph.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap(String inmap) { 
    this.inmap = inmap;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outmap;

  @LiteralDataInput(identifier = "outMap", abstrakt = "The resulting map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutMap(String outmap) { 
    this.outmap = outmap;
  }

  private String res_outmap;

  @LiteralDataOutput(identifier = "res_outMap", abstrakt = "The resulting map.", binding = LiteralStringBinding.class)
  public String getRes_outMap() { 
    return res_outmap;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int[]
    // fieldBindingType = String
    // fieldVariableType = String
  private String pkernel;

  @LiteralDataInput(identifier = "pKernel", abstrakt = "A kernel to use instead of the default.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpKernel(String pkernel) { 
    this.pkernel = pkernel;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dobinary;

  @LiteralDataInput(identifier = "doBinary", abstrakt = "Process in binary mode.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoBinary(Boolean dobinary) { 
    this.dobinary = dobinary;
  }

    // inputOutputIndicator = input
    // fileIndicator = combo:dilate,erode,skeletonize1,skeletonize2,skeletonize2var,skeletonize3,prune,open,close,lineendings,linejunctions
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pmode;

  @LiteralDataInput(identifier = "pMode", abstrakt = "The operation type to perform (dilate, erode, skeletonize(1,2,2var,3), prune, open, close, lineendings, linejunctions)", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpMode(String pmode) { 
    this.pmode = pmode;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int piterations;

  @LiteralDataInput(identifier = "pIterations", abstrakt = "Number of iterations (used in case of pruning).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpIterations(int piterations) { 
    this.piterations = piterations;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.MorpherAlgorithm");
    
    Morpher tmpModule = new Morpher(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("doBinary",  (Boolean) dobinary); 
    logger.info("doBinary " + ( (Boolean) dobinary) );
    inputs.put("pMode",  (String) pmode); 
    logger.info("pMode " + ( (String) pmode) );
    inputs.put("pKernel",  (String) pkernel); 
    logger.info("pKernel " + ( (String) pkernel) );
    inputs.put("inMap",  (String) inmap); 
    logger.info("inMap " + ( (String) inmap) );
    inputs.put("pIterations",  (int) piterations); 
    logger.info("pIterations " + ( (int) piterations) );
    inputs.put("outMap",  (String) outmap); 
    logger.info("outMap " + ( (String) outmap) );
    
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
    
    outputs.put("outMap", "String"); 
    
    res_outmap = (String) outmap; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outMap")) { 
            // and put them into the output result variables 
            res_outmap = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

