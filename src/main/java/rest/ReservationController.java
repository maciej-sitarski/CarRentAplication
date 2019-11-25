//package rest;
//
//import entity.Client;
//import entity.Worker;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import javax.ws.rs.PATCH;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.Response;
//
//@Path("/reservations")
//public class ReservationController {

//  @PATCH
//  @Path("/check/{startDepartment}/{finishDepartment}/{startDate}/{startHour}/{backDate}/{backHour}/{brandName}/{modelName}")
//  public Response checkOpportunityToRent(@PathParam("startDepartment") String startDepartment,
//      @PathParam("finishDepartment") String finishDepartment,
//      @PathParam("startDate") String startDate, @PathParam("startHour") String startHour,
//      @PathParam("backDate") String backDate, @PathParam("backHour") String backHour,
//      @PathParam("brandName") String brandName, @PathParam("modelName") String modelName)
//      throws ParseException {
//
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    Date startFormatDate = dateFormat.parse(startDate);
//    Date finishFormatDate = dateFormat.parse(backDate);
//
//    DateFormat hourFormat = new SimpleDateFormat("hh:mm");
//    Date startFormatHour = hourFormat.parse(startHour);
//    Date finishFormatHour = hourFormat.parse(backHour);
//
//    if (startFormatDate.compareTo(finishFormatDate) > 0) {
//
//    } else if (startFormatDate.compareTo(finishFormatDate) == 0
//        && startFormatHour.compareTo(finishFormatHour) > 0) {
//    }
//    return Response.ok().build();
//  }

//  @PATCH
//  @Path("/{startDepartment}/{startDate}/{startHour}/{backDate}/{backHour}/{brandName}/{modelName}")
//  public Response checkOpportunityToRent(@PathParam("startDepartment") String startDepartment,
//      @PathParam("startDate") String startDate, @PathParam("startHour") String startHour,
//      @PathParam("backDate") String backDate, @PathParam("backHour") String backHour,
//      @PathParam("brandName") String brandName, @PathParam("modelName") String modelName)
//      throws ParseException {
//
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    Date startFormatDate = dateFormat.parse(startDate);
//    Date finishFormatDate = dateFormat.parse(backDate);
//
//    DateFormat hourFormat = new SimpleDateFormat("hh:mm");
//    Date startFormatHour = hourFormat.parse(startHour);
//    Date finishFormatHour = hourFormat.parse(backHour);
//
//    if (startFormatDate.compareTo(finishFormatDate) > 0) {
//
//    } else if (startFormatDate.compareTo(finishFormatDate) == 0
//        && startFormatHour.compareTo(finishFormatHour) > 0) {
//    }
//    return Response.ok().build();
//  }
//
//}
//}
