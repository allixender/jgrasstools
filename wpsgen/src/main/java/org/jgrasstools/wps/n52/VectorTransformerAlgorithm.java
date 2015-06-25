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
import org.jgrasstools.modules.VectorTransformer; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module for vector tranforms. Currently only translation is supported.")
public class VectorTransformerAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(VectorTransformerAlgorithm.class); 

  public VectorTransformerAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String invector;

  @LiteralDataInput(identifier = "inVector", abstrakt = "The feature collection that has to be transformed.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVector(String invector) { 
    this.invector = invector;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double ptransx;

  @LiteralDataInput(identifier = "pTransX", abstrakt = "The translation along the X axis.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpTransX(double ptransx) { 
    this.ptransx = ptransx;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double ptransy;

  @LiteralDataInput(identifier = "pTransY", abstrakt = "The translation along the Y axis.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpTransY(double ptransy) { 
    this.ptransy = ptransy;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outvector;

  @LiteralDataInput(identifier = "outVector", abstrakt = "The transformed feature collection.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutVector(String outvector) { 
    this.outvector = outvector;
  }

  private String res_outvector;

  @LiteralDataOutput(identifier = "res_outVector", abstrakt = "The transformed feature collection.", binding = LiteralStringBinding.class)
  public String getRes_outVector() { 
    return res_outvector;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.VectorTransformerAlgorithm");
    
    VectorTransformer tmpModule = new VectorTransformer(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pTransY",  (double) ptransy); 
    logger.info("pTransY " + ( (double) ptransy) );
    inputs.put("outVector",  (String) outvector); 
    logger.info("outVector " + ( (String) outvector) );
    inputs.put("pTransX",  (double) ptransx); 
    logger.info("pTransX " + ( (double) ptransx) );
    inputs.put("inVector",  (String) invector); 
    logger.info("inVector " + ( (String) invector) );
    
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
    
    outputs.put("outVector", "String"); 
    
    res_outvector = (String) outvector; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outVector")) { 
            // and put them into the output result variables 
            res_outvector = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

