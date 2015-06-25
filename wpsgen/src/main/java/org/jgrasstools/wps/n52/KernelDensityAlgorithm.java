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
import org.jgrasstools.modules.KernelDensity; 
 
@Algorithm(version = "1.0.0", abstrakt = "Kernel Density Estimator (based on the Jaitools project).")
public class KernelDensityAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(KernelDensityAlgorithm.class); 

  public KernelDensityAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap;

  @LiteralDataInput(identifier = "inMap", abstrakt = "The input map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap(String inmap) { 
    this.inmap = inmap;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pkernel;

  @LiteralDataInput(identifier = "pKernel", abstrakt = "The kernel to use.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpKernel(int pkernel) { 
    this.pkernel = pkernel;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pradius;

  @LiteralDataInput(identifier = "pRadius", abstrakt = "The kernel radius to use in cells (default = 10).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpRadius(int pradius) { 
    this.pradius = pradius;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean doconstant;

  @LiteralDataInput(identifier = "doConstant", abstrakt = "Use a constant value for the existing input map values instead of the real map value (default = false).", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoConstant(Boolean doconstant) { 
    this.doconstant = doconstant;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outdensity;

  @LiteralDataInput(identifier = "outDensity", abstrakt = "The kernel density estimation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutDensity(String outdensity) { 
    this.outdensity = outdensity;
  }

  private String res_outdensity;

  @LiteralDataOutput(identifier = "res_outDensity", abstrakt = "The kernel density estimation.", binding = LiteralStringBinding.class)
  public String getRes_outDensity() { 
    return res_outdensity;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.KernelDensityAlgorithm");
    
    KernelDensity tmpModule = new KernelDensity(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pRadius",  (int) pradius); 
    logger.info("pRadius " + ( (int) pradius) );
    inputs.put("pKernel",  (int) pkernel); 
    logger.info("pKernel " + ( (int) pkernel) );
    inputs.put("outDensity",  (String) outdensity); 
    logger.info("outDensity " + ( (String) outdensity) );
    inputs.put("inMap",  (String) inmap); 
    logger.info("inMap " + ( (String) inmap) );
    inputs.put("doConstant",  (Boolean) doconstant); 
    logger.info("doConstant " + ( (Boolean) doconstant) );
    
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
    
    outputs.put("outDensity", "String"); 
    
    res_outdensity = (String) outdensity; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outDensity")) { 
            // and put them into the output result variables 
            res_outdensity = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

