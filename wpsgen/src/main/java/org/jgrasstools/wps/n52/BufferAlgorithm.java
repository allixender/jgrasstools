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
import org.jgrasstools.modules.Buffer; 
 
@Algorithm(version = "1.0.0", abstrakt = "A module that performs a buffer operation on a vector layer.")
public class BufferAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(BufferAlgorithm.class); 

  public BufferAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap;

  @LiteralDataInput(identifier = "inMap", abstrakt = "The input vector map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap(String inmap) { 
    this.inmap = inmap;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pbuffer;

  @LiteralDataInput(identifier = "pBuffer", abstrakt = "The buffer distance.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpBuffer(double pbuffer) { 
    this.pbuffer = pbuffer;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dosinglesided;

  @LiteralDataInput(identifier = "doSinglesided", abstrakt = "Flag to toggle singlesided buffer.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoSinglesided(Boolean dosinglesided) { 
    this.dosinglesided = dosinglesided;
  }

    // inputOutputIndicator = input
    // fileIndicator = combo:round,mitre,bevel
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pjoinstyle;

  @LiteralDataInput(identifier = "pJoinstyle", abstrakt = "The join style to use.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpJoinstyle(String pjoinstyle) { 
    this.pjoinstyle = pjoinstyle;
  }

    // inputOutputIndicator = input
    // fileIndicator = combo:round,flat,square
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pcapstyle;

  @LiteralDataInput(identifier = "pCapstyle", abstrakt = "The cap style to use.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpCapstyle(String pcapstyle) { 
    this.pcapstyle = pcapstyle;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outmap;

  @LiteralDataInput(identifier = "outMap", abstrakt = "The buffered vector map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutMap(String outmap) { 
    this.outmap = outmap;
  }

  private String res_outmap;

  @LiteralDataOutput(identifier = "res_outMap", abstrakt = "The buffered vector map.", binding = LiteralStringBinding.class)
  public String getRes_outMap() { 
    return res_outmap;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.BufferAlgorithm");
    
    Buffer tmpModule = new Buffer(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pCapstyle",  (String) pcapstyle); 
    logger.info("pCapstyle " + ( (String) pcapstyle) );
    inputs.put("pBuffer",  (double) pbuffer); 
    logger.info("pBuffer " + ( (double) pbuffer) );
    inputs.put("inMap",  (String) inmap); 
    logger.info("inMap " + ( (String) inmap) );
    inputs.put("doSinglesided",  (Boolean) dosinglesided); 
    logger.info("doSinglesided " + ( (Boolean) dosinglesided) );
    inputs.put("outMap",  (String) outmap); 
    logger.info("outMap " + ( (String) outmap) );
    inputs.put("pJoinstyle",  (String) pjoinstyle); 
    logger.info("pJoinstyle " + ( (String) pjoinstyle) );
    
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

