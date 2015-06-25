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
import org.jgrasstools.modules.NetNumbering; 
 
@Algorithm(version = "1.0.0", abstrakt = "Assigns the numbers to the network's links.")
public class NetNumberingAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(NetNumberingAlgorithm.class); 

  public NetNumberingAlgorithm() { 
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

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intca;

  @LiteralDataInput(identifier = "inTca", abstrakt = "The map of total contributing area.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTca(String intca) { 
    this.intca = intca;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innet;

  @LiteralDataInput(identifier = "inNet", abstrakt = "The map of the network.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNet(String innet) { 
    this.innet = innet;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inpoints;

  @LiteralDataInput(identifier = "inPoints", abstrakt = "The monitoringpoints vector map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinPoints(String inpoints) { 
    this.inpoints = inpoints;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pthres;

  @LiteralDataInput(identifier = "pThres", abstrakt = "Threshold value on tca map.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpThres(double pthres) { 
    this.pthres = pthres;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fpointid;

  @LiteralDataInput(identifier = "fPointId", abstrakt = "The name of the node id field in mode 2.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfPointId(String fpointid) { 
    this.fpointid = fpointid;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outnetnum;

  @LiteralDataInput(identifier = "outNetnum", abstrakt = "The map of netnumbering", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutNetnum(String outnetnum) { 
    this.outnetnum = outnetnum;
  }

  private String res_outnetnum;

  @LiteralDataOutput(identifier = "res_outNetnum", abstrakt = "The map of netnumbering", binding = LiteralStringBinding.class)
  public String getRes_outNetnum() { 
    return res_outnetnum;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outbasins;

  @LiteralDataInput(identifier = "outBasins", abstrakt = "The map of subbasins", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutBasins(String outbasins) { 
    this.outbasins = outbasins;
  }

  private String res_outbasins;

  @LiteralDataOutput(identifier = "res_outBasins", abstrakt = "The map of subbasins", binding = LiteralStringBinding.class)
  public String getRes_outBasins() { 
    return res_outbasins;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.NetNumberingAlgorithm");
    
    NetNumbering tmpModule = new NetNumbering(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inPoints",  (String) inpoints); 
    logger.info("inPoints " + ( (String) inpoints) );
    inputs.put("inTca",  (String) intca); 
    logger.info("inTca " + ( (String) intca) );
    inputs.put("fPointId",  (String) fpointid); 
    logger.info("fPointId " + ( (String) fpointid) );
    inputs.put("inNet",  (String) innet); 
    logger.info("inNet " + ( (String) innet) );
    inputs.put("outBasins",  (String) outbasins); 
    logger.info("outBasins " + ( (String) outbasins) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("pThres",  (double) pthres); 
    logger.info("pThres " + ( (double) pthres) );
    inputs.put("outNetnum",  (String) outnetnum); 
    logger.info("outNetnum " + ( (String) outnetnum) );
    
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
    
    outputs.put("outBasins", "String"); 
    outputs.put("outNetnum", "String"); 
    
    res_outbasins = (String) outbasins; 
    res_outnetnum = (String) outnetnum; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outBasins")) { 
            // and put them into the output result variables 
            res_outbasins = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outNetnum")) { 
            // and put them into the output result variables 
            res_outnetnum = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

