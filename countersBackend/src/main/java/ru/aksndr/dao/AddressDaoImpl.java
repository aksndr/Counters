package ru.aksndr.dao;

import org.hibernate.Query;
import org.hibernate.criterion.Example;
import ru.aksndr.entity.Address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: a.arzamastsev Date: 29.08.13 Time: 11:57
 */
public class AddressDaoImpl extends AbstractDao implements AddressDao {

    @Override
    public Address getAddressByUserId(long userId) {
        Address address = new Address();
        List addresses = new ArrayList<Address>();
        address.setUserId(userId);
//        addresses = getSession().createCriteria(Address.class).add(Example.create(address)).list();
        Query query = getSession().createQuery("select a from Address a where a.userId = :uId ")
                .setLong("uId", userId);
        addresses = query.list();
        if (!addresses.isEmpty())
            return (Address)addresses.get(0);
        return null;
    }

    @Override
    public void addAddress(Address address) {
        getSession().save(address);
    }
}
