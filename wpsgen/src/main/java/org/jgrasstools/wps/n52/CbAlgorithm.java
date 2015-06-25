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
import org.jgrasstools.modules.Cb; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculates the histogram of a set of data contained in a matrix with respect to the set of data contained in another matrix.")
public class CbAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(CbAlgorithm.class); 

  public CbAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster1;

  @LiteralDataInput(identifier = "inRaster1", abstrakt = "The first raster to analyse.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster1(String inraster1) { 
    this.inraster1 = inraster1;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster2;

  @LiteralDataInput(identifier = "inRaster2", abstrakt = "The second raster to analyse.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster2(String inraster2) { 
    this.inraster2 = inraster2;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pbins;

  @LiteralDataInput(identifier = "pBins", abstrakt = "The number of bins into which divide the data range.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpBins(int pbins) { 
    this.pbins = pbins;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pfirst;

  @LiteralDataInput(identifier = "pFirst", abstrakt = "The first moment to calculate.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpFirst(int pfirst) { 
    this.pfirst = pfirst;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int plast;

  @LiteralDataInput(identifier = "pLast", abstrakt = "The last moment to calculate.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpLast(int plast) { 
    this.plast = plast;
  }

    // inputOutputIndicator = output
    // fileIndicator = null
    // fieldType = double[][]
    // fieldBindingType = String
    // fieldVariableType = String
  private String res_outcb;

  @LiteralDataOutput(identifier = "res_outCb", abstrakt = "A matrix containing 1) the mean value of the data in abscissa; 2) the number of elements in each interval; 3) the mean value of the data in ordinate; n+2) the n-esimal moment of the data in ordinate.", binding = LiteralStringBinding.class)
  public String getRes_outCb() { 
    return res_outcb;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.CbAlgorithm");
    
    Cb tmpModule = new Cb(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inRaster2",  (String) inraster2); 
    logger.info("inRaster2 " + ( (String) inraster2) );
    inputs.put("pLast",  (int) plast); 
    logger.info("pLast " + ( (int) plast) );
    inputs.put("pBins",  (int) pbins); 
    logger.info("pBins " + ( (int) pbins) );
    inputs.put("pFirst",  (int) pfirst); 
    logger.info("pFirst " + ( (int) pfirst) );
    inputs.put("inRaster1",  (String) inraster1); 
    logger.info("inRaster1 " + ( (String) inraster1) );
    
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
    
    outputs.put("outCb", "String"); 
    
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outCb")) { 
            // and put them into the output result variables 
            res_outcb = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

