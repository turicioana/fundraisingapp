package fundraisingapp.Base.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity(name = "Image")
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="photo_blob")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] photoBlob;

    @Column(name = "photo_content_length")
    private Integer photoContentLength;

    @Column(name = "photo_content_type", length = 50)
    private String photoContentType;

    @ManyToOne
    @JoinTable(
            name = "images_fundraisers",
            joinColumns = @JoinColumn(
                    name = "image_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "fundraiser_id", referencedColumnName = "id"))
    private Fundraiser fundraiser;

    public Image() {
    }
}
