package eCommerceApp.demo.Model.Cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eCommerceApp.demo.Model.Client.Client;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String blablabla;

    public String getBlablabla() {
        return blablabla;
    }

    public void setBlablabla(String blablabla) {
        this.blablabla = blablabla;
    }

    @OneToOne(mappedBy = "cart")
    @JsonIgnore
    private Client client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
