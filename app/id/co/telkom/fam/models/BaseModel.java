package id.co.telkom.fam.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import id.co.telkom.fam.utils.Constants;
import io.ebean.Model;
import io.ebean.annotation.SoftDelete;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@JsonPropertyOrder(value = {"id", "createdAt", "deleted", "updatedAt"}, alphabetic = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public abstract class BaseModel extends Model {
    @SoftDelete
    @Column(name = "deleted")
    public boolean deleted;

    @Column(name = "created_at")
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
    public Date createdAt;

    @Column(name = "updated_at")
    @JsonFormat(pattern = Constants.DATE_FORMAT, timezone = Constants.TIME_ZONE)
    public Date updatedAt;
}