package eu.pretix.libpretixsync.db;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import eu.pretix.libpretixsync.BuildConfig;
import io.requery.Column;
import io.requery.Entity;
import io.requery.ForeignKey;
import io.requery.Generated;
import io.requery.Key;
import io.requery.ManyToOne;
import io.requery.Nullable;
import io.requery.OneToMany;
import io.requery.OneToOne;

@Entity(cacheable = false)
public class AbstractReceiptLine implements LocalObject {
    @Generated
    @Key
    public Long id;

    @ForeignKey
    @ManyToOne
    public Receipt receipt;

    public String type;

    public Long positionid;

    public boolean canceled;

    public BigDecimal price;

    public BigDecimal taxrate;

    @Column(value = BuildConfig.BOOLEAN_FALSE)
    public boolean price_calculated_from_net;

    @Column(value = BuildConfig.BOOLEAN_FALSE)
    public boolean canceled_because_of_receipt;

    public Long tax_rule;

    public BigDecimal tax_value;

    @Nullable
    public String secret;

    @Nullable
    public Long subevent_id;

    @Nullable
    public String subevent_text;

    @Nullable
    public String event_date_from;

    @Nullable
    public String event_date_to;

    @Nullable
    public String seat_guid;

    @Nullable
    public String seat_name;

    @Nullable
    public Long item_id;

    @Nullable
    public Long variation_id;

    public String sale_text;

    @Nullable
    public Long cart_position_id;

    @Nullable
    public Date created;

    @Nullable
    public String cart_id;

    @Nullable
    public String remote_error;

    @Nullable
    public Date cart_expires;

    @ForeignKey
    @ManyToOne
    @Nullable
    public ReceiptLine addon_to;

    @OneToMany
    public List<ReceiptLine> addons;

    @Nullable
    public String answers;

    @Nullable
    public String attendee_name;

    @Nullable
    public String attendee_email;

    @Nullable
    public String attendee_company;

    @Nullable
    public String attendee_street;

    @Nullable
    public String attendee_zipcode;

    @Nullable
    public String attendee_city;

    @Nullable
    public String attendee_country;

    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put("id", id);
        jo.put("type", type);
        jo.put("position_id", positionid);
        jo.put("canceled", canceled);
        jo.put("canceled_because_of_receipt", canceled_because_of_receipt);
        jo.put("price_calculated_from_net", price_calculated_from_net);
        jo.put("price", price);
        jo.put("tax_rate", tax_rate != null ? tax_rate : "0.00");
        jo.put("tax_value", tax_value != null ? tax_value : "0.00");
        jo.put("tax_rule", tax_rule != null ? tax_rule : JSONObject.NULL);
        jo.put("secret", secret);
        jo.put("seat", seat_guid != null ? seat_guid : JSONObject.NULL);
        jo.put("subevent", subevent_id);
        jo.put("event_date_from", event_date_from != null && event_date_from.length() > 5 ? event_date_from : JSONObject.NULL);
        jo.put("event_date_to", event_date_to != null && event_date_to.length() > 5 ? event_date_to : JSONObject.NULL);
        jo.put("subevent_text", subevent_text != null && subevent_text.length() > 0 && !subevent_text.equals("null") ? subevent_text : JSONObject.NULL);
        jo.put("item", item_id != null && item_id != 0L ? item_id : JSONObject.NULL);
        jo.put("variation", variation_id);
        jo.put("answers", answers);
        jo.put("sale_text", sale_text);
        jo.put("addon_to", JSONObject.NULL);
        jo.put("attendee_name", attendee_name);
        jo.put("attendee_email", attendee_email);
        jo.put("attendee_company", attendee_company);
        jo.put("attendee_street", attendee_street);
        jo.put("attendee_zipcode", attendee_zipcode);
        jo.put("attendee_city", attendee_city);
        jo.put("attendee_country", attendee_country);
        return jo;
    }
}
