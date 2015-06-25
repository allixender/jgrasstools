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
import org.jgrasstools.modules.LW09_AreaToNetpointAssociator; 
 
@Algorithm(version = "1.0.0", abstrakt = "Calculate median vegetation height and total timber volume of the vegetation on unstable and connected areas of each subbasin.")
public class LW09_AreaToNetpointAssociatorAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(LW09_AreaToNetpointAssociatorAlgorithm.class); 

  public LW09_AreaToNetpointAssociatorAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innetpoints;

  @LiteralDataInput(identifier = "inNetPoints", abstrakt = "The input hierarchy point network layer.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNetPoints(String innetpoints) { 
    this.innetpoints = innetpoints;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ininundationarea;

  @LiteralDataInput(identifier = "inInundationArea", abstrakt = "The input polygon layer with the inundation areas.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinInundationArea(String ininundationarea) { 
    this.ininundationarea = ininundationarea;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inflow;

  @LiteralDataInput(identifier = "inFlow", abstrakt = "The input flow directions raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlow(String inflow) { 
    this.inflow = inflow;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intca;

  @LiteralDataInput(identifier = "inTca", abstrakt = "The input total contributing areas raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTca(String intca) { 
    this.intca = intca;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innet;

  @LiteralDataInput(identifier = "inNet", abstrakt = "The input network raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNet(String innet) { 
    this.innet = innet;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String indtm;

  @LiteralDataInput(identifier = "inDtm", abstrakt = "The input terrain elevation raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinDtm(String indtm) { 
    this.indtm = indtm;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String indsm;

  @LiteralDataInput(identifier = "inDsm", abstrakt = "The input superficial elevation raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinDsm(String indsm) { 
    this.indsm = indsm;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String instand;

  @LiteralDataInput(identifier = "inStand", abstrakt = "The input total stand volume raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinStand(String instand) { 
    this.instand = instand;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inslope;

  @LiteralDataInput(identifier = "inSlope", abstrakt = "The input slope raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSlope(String inslope) { 
    this.inslope = inslope;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inconnectivity;

  @LiteralDataInput(identifier = "inConnectivity", abstrakt = "The input downslope connectivity index raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinConnectivity(String inconnectivity) { 
    this.inconnectivity = inconnectivity;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pconnectivitythreshold;

  @LiteralDataInput(identifier = "pConnectivityThreshold", abstrakt = "Threshold on connectivity map for extracting unstable connected pixels of the basins.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpConnectivityThreshold(double pconnectivitythreshold) { 
    this.pconnectivitythreshold = pconnectivitythreshold;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outnetpoints;

  @LiteralDataInput(identifier = "outNetPoints", abstrakt = "The output points network layer with the additional attributes vegetation height and timber volume .", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutNetPoints(String outnetpoints) { 
    this.outnetpoints = outnetpoints;
  }

  private String res_outnetpoints;

  @LiteralDataOutput(identifier = "res_outNetPoints", abstrakt = "The output points network layer with the additional attributes vegetation height and timber volume .", binding = LiteralStringBinding.class)
  public String getRes_outNetPoints() { 
    return res_outnetpoints;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outnetnum;

  @LiteralDataInput(identifier = "outNetnum", abstrakt = "The output netnumbering raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutNetnum(String outnetnum) { 
    this.outnetnum = outnetnum;
  }

  private String res_outnetnum;

  @LiteralDataOutput(identifier = "res_outNetnum", abstrakt = "The output netnumbering raster map.", binding = LiteralStringBinding.class)
  public String getRes_outNetnum() { 
    return res_outnetnum;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outbasins;

  @LiteralDataInput(identifier = "outBasins", abstrakt = "The output subbasins raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutBasins(String outbasins) { 
    this.outbasins = outbasins;
  }

  private String res_outbasins;

  @LiteralDataOutput(identifier = "res_outBasins", abstrakt = "The output subbasins raster map.", binding = LiteralStringBinding.class)
  public String getRes_outBasins() { 
    return res_outbasins;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.LW09_AreaToNetpointAssociatorAlgorithm");
    
    LW09_AreaToNetpointAssociator tmpModule = new LW09_AreaToNetpointAssociator(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inNetPoints",  (String) innetpoints); 
    logger.info("inNetPoints " + ( (String) innetpoints) );
    inputs.put("inTca",  (String) intca); 
    logger.info("inTca " + ( (String) intca) );
    inputs.put("inSlope",  (String) inslope); 
    logger.info("inSlope " + ( (String) inslope) );
    inputs.put("inNet",  (String) innet); 
    logger.info("inNet " + ( (String) innet) );
    inputs.put("outBasins",  (String) outbasins); 
    logger.info("outBasins " + ( (String) outbasins) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    inputs.put("inDsm",  (String) indsm); 
    logger.info("inDsm " + ( (String) indsm) );
    inputs.put("outNetnum",  (String) outnetnum); 
    logger.info("outNetnum " + ( (String) outnetnum) );
    inputs.put("inInundationArea",  (String) ininundationarea); 
    logger.info("inInundationArea " + ( (String) ininundationarea) );
    inputs.put("inDtm",  (String) indtm); 
    logger.info("inDtm " + ( (String) indtm) );
    inputs.put("inConnectivity",  (String) inconnectivity); 
    logger.info("inConnectivity " + ( (String) inconnectivity) );
    inputs.put("inStand",  (String) instand); 
    logger.info("inStand " + ( (String) instand) );
    inputs.put("pConnectivityThreshold",  (double) pconnectivitythreshold); 
    logger.info("pConnectivityThreshold " + ( (double) pconnectivitythreshold) );
    inputs.put("outNetPoints",  (String) outnetpoints); 
    logger.info("outNetPoints " + ( (String) outnetpoints) );
    
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
    outputs.put("outNetPoints", "String"); 
    outputs.put("outNetnum", "String"); 
    
    res_outbasins = (String) outbasins; 
    res_outnetpoints = (String) outnetpoints; 
    res_outnetnum = (String) outnetnum; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outBasins")) { 
            // and put them into the output result variables 
            res_outbasins = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outNetPoints")) { 
            // and put them into the output result variables 
            res_outnetpoints = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outNetnum")) { 
            // and put them into the output result variables 
            res_outnetnum = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

