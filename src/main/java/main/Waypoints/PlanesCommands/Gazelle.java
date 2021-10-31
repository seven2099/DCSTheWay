package main.Waypoints.PlanesCommands;

import main.Utils.CoordinateUtils;
import main.Utils.UnitConvertorUtils;
import main.models.DMMCoordinate;
import main.models.DMSCoordinate;
import main.models.Hemisphere;
import main.models.Point;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Gazelle {
    /*
            NADIR, device 23
            Enter 		           3004
			Del/Eff		           3023
			Down arrow	           3008
			Doppler mode TERRE     3002 0.3
			Parameter selector BUT 3003 1

            0 - 		3009
            1 - 		3010
            2 (north) - 3011
            3 - 		3012
            4 (west) - 	3013
            5 - 		3014
            6 (east) - 	3015
            7 - 		3016
            8 (south) - 3017
            9 - 		3018

         */

    public static JSONArray getCommands(List<Point> coords) {
        JSONArray commandArray = new JSONArray();

        //Select NADIR TERRE
        commandArray.put(new JSONObject().put("device", "23").put("code", "3002").put("delay", "0").put("activate", "0.3").put("addDepress", "false"));
        //Select NADIR BUT
        commandArray.put(new JSONObject().put("device", "23").put("code", "3003").put("delay", "0").put("activate", "1").put("addDepress", "false"));

        for(int i=1; i<= coords.size(); i++){
            //Press the corresponding waypoint number
            switch (i){
                case 1:
                    commandArray.put(new JSONObject().put("device", "23").put("code", "3010").put("delay", "1").put("activate", "1").put("addDepress", "true"));
                    break;
                case 2:
                    commandArray.put(new JSONObject().put("device", "23").put("code", "3011").put("delay", "1").put("activate", "1").put("addDepress", "true"));
                    break;
                case 3:
                    commandArray.put(new JSONObject().put("device", "23").put("code", "3012").put("delay", "1").put("activate", "1").put("addDepress", "true"));
                    break;
                case 4:
                    commandArray.put(new JSONObject().put("device", "23").put("code", "3013").put("delay", "1").put("activate", "1").put("addDepress", "true"));
                    break;
                case 5:
                    commandArray.put(new JSONObject().put("device", "23").put("code", "3014").put("delay", "1").put("activate", "1").put("addDepress", "true"));
                    break;
                case 6:
                    commandArray.put(new JSONObject().put("device", "23").put("code", "3015").put("delay", "1").put("activate", "1").put("addDepress", "true"));
                    break;
                case 7:
                    commandArray.put(new JSONObject().put("device", "23").put("code", "3016").put("delay", "1").put("activate", "1").put("addDepress", "true"));
                    break;
                case 8:
                    commandArray.put(new JSONObject().put("device", "23").put("code", "3017").put("delay", "1").put("activate", "1").put("addDepress", "true"));
                    break;
                case 9:
                    commandArray.put(new JSONObject().put("device", "23").put("code", "3018").put("delay", "1").put("activate", "1").put("addDepress", "true"));
                    break;
            }
            //Press ENT
            commandArray.put(new JSONObject().put("device", "23").put("code", "3004").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            //Clear latitude, press EFF 7 times
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            //Check if latitude is N or S
            if (coords.get(i-1).getLatitudeHemisphere() == Hemisphere.NORTH) {
                //press 2 for North
                commandArray.put(new JSONObject().put("device", "23").put("code", "3011").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            } else {
                //press 8 for South
                commandArray.put(new JSONObject().put("device", "23").put("code", "3017").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            }
            //Start typing latitude
            for(char digit:coords.get(i-1).getLatitude().toCharArray()){
                switch (digit){
                    case '1':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3010").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '2':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3011").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '3':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3012").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '4':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3013").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '5':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3014").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '6':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3015").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '7':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3016").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '8':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3017").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '9':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3018").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '0':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3009").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                }
            }
            //Press NADIR down arrow
            commandArray.put(new JSONObject().put("device", "23").put("code", "3008").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            //Clear Longitude, press EFF 7 times
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "60").put("activate", "0").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "5").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "5").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "5").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "5").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "5").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "5").put("activate", "1").put("addDepress", "true"));
            commandArray.put(new JSONObject().put("device", "23").put("code", "3023").put("delay", "5").put("activate", "1").put("addDepress", "true"));
            //Check if longitude is E or W
            if (coords.get(i-1).getLongitudeHemisphere() == Hemisphere.EAST) {
                //press 6 for East
                commandArray.put(new JSONObject().put("device", "23").put("code", "3015").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            } else {
                //press 4 for West
                commandArray.put(new JSONObject().put("device", "23").put("code", "3013").put("delay", "1").put("activate", "1").put("addDepress", "true"));
            }
            //Start typing longitude
            for(char digit:coords.get(i-1).getLongitude().toCharArray()){
                switch (digit){
                    case '1':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3010").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '2':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3011").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '3':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3012").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '4':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3013").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '5':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3014").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '6':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3015").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '7':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3016").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '8':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3017").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '9':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3018").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '0':
                        commandArray.put(new JSONObject().put("device", "23").put("code", "3009").put("delay", "10").put("activate", "1").put("addDepress", "true"));
                        break;
                }
            }
            //Press ENT
            commandArray.put(new JSONObject().put("device", "23").put("code", "3004").put("delay", "1").put("activate", "1").put("addDepress", "true"));
        }

        return commandArray;
    }

    public static List<Point> getCoords(List<Point> dcsPoints) {
        List<Point> GazellePoints = new ArrayList<>();
        for (Point dcsPoint : dcsPoints) {
            BigDecimal dcsLat = new BigDecimal(dcsPoint.getLatitude());
            BigDecimal dcsLong = new BigDecimal(dcsPoint.getLongitude());
            Double dcsElev = Double.parseDouble(dcsPoint.getElevation());

            DMSCoordinate dmsLat = CoordinateUtils.decimalToDMS(dcsLat);
            DMSCoordinate dmsLong = CoordinateUtils.decimalToDMS(dcsLong);

            DecimalFormat latDegDf = new DecimalFormat("00");
            DecimalFormat latMinDf = new DecimalFormat("00");
            DecimalFormat longDegDf = new DecimalFormat("#00");
            DecimalFormat longMinDf = new DecimalFormat("00");
            String GazelleLatitude = latDegDf.format(dmsLat.getDegrees()) + latMinDf.format(dmsLat.getMinutes()) + String.valueOf(dmsLat.getSeconds()).charAt(0);
            String GazelleLongitude = longDegDf.format(dmsLong.getDegrees()) + longMinDf.format(dmsLong.getMinutes()) + String.valueOf(dmsLong.getSeconds()).charAt(0);
            String GazelleElevation = String.valueOf(Math.round(UnitConvertorUtils.metersToFeet(dcsElev)));

            var GazellePoint = new Point(GazelleLatitude, GazelleLongitude, GazelleElevation, dcsPoint.getLatitudeHemisphere(), dcsPoint.getLongitudeHemisphere());
            GazellePoints.add(GazellePoint);
        }
        return GazellePoints;
    }
}
