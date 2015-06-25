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
import org.jgrasstools.modules.MultiTca; 
 
@Algorithm(version = "1.0.0", abstrakt = "It calculates the contributing areas differently in convex and concave areas")
public class MultiTcaAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(MultiTcaAlgorithm.class); 

  public MultiTcaAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inpit;

  @LiteralDataInput(identifier = "inPit", abstrakt = "The map of depitted elevation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
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
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String incp9;

  @LiteralDataInput(identifier = "inCp9", abstrakt = "The map with the Thopological classes cp9.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinCp9(String incp9) { 
    this.incp9 = incp9;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outmultitca;

  @LiteralDataInput(identifier = "outMultiTca", abstrakt = "The map of total contributing areas.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutMultiTca(String outmultitca) { 
    this.outmultitca = outmultitca;
  }

  private String res_outmultitca;

  @LiteralDataOutput(identifier = "res_outMultiTca", abstrakt = "The map of total contributing areas.", binding = LiteralStringBinding.class)
  public String getRes_outMultiTca() { 
    return res_outmultitca;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.MultiTcaAlgorithm");
    
    MultiTca tmpModule = new MultiTca(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("outMultiTca",  (String) outmultitca); 
    logger.info("outMultiTca " + ( (String) outmultitca) );
    inputs.put("inPit",  (String) inpit); 
    logger.info("inPit " + ( (String) inpit) );
    inputs.put("inCp9",  (String) incp9); 
    logger.info("inCp9 " + ( (String) incp9) );
    
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
    
    outputs.put("outMultiTca", "String"); 
    
    res_outmultitca = (String) outmultitca; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outMultiTca")) { 
            // and put them into the output result variables 
            res_outmultitca = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

