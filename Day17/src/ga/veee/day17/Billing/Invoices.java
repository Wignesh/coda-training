package ga.veee.day17.Billing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;

public class Invoices {
    Map<String, Object> invoiceInfo;

    public Invoices() {
        this.invoiceInfo = Map.of(
                "companyInfo", Map.of(
                        "name", "ABC Corp",
                        "address", Map.of(
                                "street", "123, A Street",
                                "city", "CHENNAI",
                                "state", "TAMILNADU",
                                "country", "INDIA",
                                "zip", "900700"

                        ),
                        "phone", "9087654321",
                        "email", "abc-corp@abc.com"
                ),
                "invoiceInfo", Map.of(
                        "date", LocalDateTime.now(),
                        "dueDate", LocalDateTime.now().plus(1, ChronoUnit.DAYS),
                        "id", UUID.randomUUID(),
                        "invoiceCurrency",Currencies.USD
                ),
                "billTo", Map.of(
                        "contactName", "A Person",
                        "companyName", "BCD Corp",
                        "address", Map.of(
                                "street", "123, B Street",
                                "city", "CHENNAI",
                                "state", "TAMILNADU",
                                "country", "INDIA",
                                "zip", "800700"

                        ),
                        "phone", "1234567890",
                        "email", "bcd-corp@bcd.com"
                ),
                "shipTo", Map.of(
                        "contactName", "B Person",
                        "companyName", "BCD Corp",
                        "address", Map.of(
                                "street", "123, B Street",
                                "city", "COIMBATORE",
                                "state", "TAMILNADU",
                                "country", "INDIA",
                                "zip", "300700"

                        ),
                        "phone", "7890654321",
                        "email", "bcd-corp-cbe@bcd.com"
                ),
                "invoicedItems", new Map[]{
                        Map.of(
                                "description", "PEN",
                                "quantity", 2,
                                "unitPrice", 23,
                                "currency", Currencies.INR,
                                "total", 46,
                                "itemId", 1
                        ),
                        Map.of(
                                "description", "PAPER",
                                "quantity", 2,
                                "unitPrice", 5,
                                "currency", Currencies.INR,
                                "total", 10,
                                "itemId", 2

                        )
                },
                "remarks", "PAY ASAP",
                "payInfo", Map.of(
                        "subTotal", 56,
                        "discountPercent", 2,
                        "discountAmount", 0,
                        "subTotalAfterDiscount", 44.8,
                        "cGSTPercent", 9,
                        "sGSTPercent", 9,
                        "totalTaxAmount", 8.064,
                        "totalTaxPercent", 18,
                        "shippingCharges", 3,
                        "totalPayable", 55.864
                )

        );
//        for (Map item : (Map[]) invoiceInfo.get("invoicedItems")) {
//            System.out.println(Currencies.valueOf(item.get("currency").toString()).Symbol());
//        }
    }
}

