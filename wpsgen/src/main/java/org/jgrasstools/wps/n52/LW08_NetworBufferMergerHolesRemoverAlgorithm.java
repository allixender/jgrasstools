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
import org.jgrasstools.modules.LW08_NetworBufferMergerHolesRemover; 
 
@Algorithm(version = "1.0.0", abstrakt = "Merge the inundated polygons to avoid strange perimeters.")
public class LW08_NetworBufferMergerHolesRemoverAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(LW08_NetworBufferMergerHolesRemoverAlgorithm.class); 

  public LW08_NetworBufferMergerHolesRemoverAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ininundationarea;

  @LiteralDataInput(identifier = "inInundationArea", abstrakt = "The input polygon layer with the inundation polygons.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinInundationArea(String ininundationarea) { 
    this.ininundationarea = ininundationarea;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outinundationarea;

  @LiteralDataInput(identifier = "outInundationArea", abstrakt = "The output polygon layer with the merged and without holes inundation polygons.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutInundationArea(String outinundationarea) { 
    this.outinundationarea = outinundationarea;
  }

  private String res_outinundationarea;

  @LiteralDataOutput(identifier = "res_outInundationArea", abstrakt = "The output polygon layer with the merged and without holes inundation polygons.", binding = LiteralStringBinding.class)
  public String getRes_outInundationArea() { 
    return res_outinundationarea;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.LW08_NetworBufferMergerHolesRemoverAlgorithm");
    
    LW08_NetworBufferMergerHolesRemover tmpModule = new LW08_NetworBufferMergerHolesRemover(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outInundationArea",  (String) outinundationarea); 
    logger.info("outInundationArea " + ( (String) outinundationarea) );
    inputs.put("inInundationArea",  (String) ininundationarea); 
    logger.info("inInundationArea " + ( (String) ininundationarea) );
    
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
    
    outputs.put("outInundationArea", "String"); 
    
    res_outinundationarea = (String) outinundationarea; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outInundationArea")) { 
            // and put them into the output result variables 
            res_outinundationarea = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

