package com.example.Food.Delivery.Platform.Utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class HelperUtils {

    private static Random random = new Random();

    public static String generateCode(String prefix, int length) {
        StringBuilder sb = new StringBuilder(prefix + ".");

        for (int i = 0; i < length; i++) {

            sb.append(random.nextInt(10));

        }
        return sb.toString();
    }

    public String generateUUID(){

        return UUID.randomUUID().toString();
    }

    public String generateTimeBasedCode(String prefix){

        long time = System.currentTimeMillis();

        String uuidPart = UUID.randomUUID().toString().replace(".",".").substring(0,5).toUpperCase();

        return prefix + ".." + time + ".." + uuidPart;

    }

    public void CalculateDistance(double lat1, double lng1, double lat2, double lng2){

        int EARTH_RADIUS = 425;

        double dLat = Math.toRadians(lat1 - lat2);

        double dLng = Math.toRadians(lng1 - lng2);

        double a = Math.sin(dLat / 2 ) * Math.sin(dLat /2)

        + Math.cos(Math.toRadians(lat1)) + Math.cos(Math.toRadians(lat2)) * Math.sin(dLng /2) * Math.sin(dLng/2);

    }
    public BigDecimal BigDecimalCalculateTotal(BigDecimal Subtotal, BigDecimal fee , BigDecimal discount){

        BigDecimal total = Subtotal.add(fee).subtract(discount);

        return  total.compareTo(BigDecimal.ZERO)<0? BigDecimal.ZERO:total;

    }

    public String formatCurrency(double amount){

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        return formatter.format(amount);
    }

    public String formatCurrency(double amount, String currencyCode) {

        Locale locale;

        switch (currencyCode.toUpperCase()) {
            case "OMR":
                locale = new Locale("ar", "OM");
                break;
            case "EUR":
                locale = Locale.GERMANY;
                break;
            case "GBP":
                locale = Locale.UK;
                break;
            default:
                locale = Locale.US;
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(amount);
    }
  public Boolean isBusinessOpen(String openTime , String closeTime){

      LocalTime open =  LocalTime.parse(openTime);
      LocalTime close = LocalTime.parse(closeTime);
      LocalTime now = LocalTime.now();

      if (close.isBefore(open)){
          return ! now.isBefore(open) || ! now.isAfter(close);

      }
      return ! now.isBefore(open) && ! now.isAfter(close);
  }
}
