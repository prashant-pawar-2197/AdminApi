package com.app.pojos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Properties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="transaction_seq")
	@GenericGenerator(name= "transaction_seq", strategy = "com.app.pojos.TransactionIdSequenceGenerator",
			parameters = {@Parameter(name =TransactionIdSequenceGenerator.INCREMENT_PARAM, value="1"), 
					@Parameter(name =TransactionIdSequenceGenerator.VALUE_PREFIX_PARAMETER, value="TR_"),
					@Parameter(name =TransactionIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value="%05d") })
	private int transactionId;
	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;
	@Column(length = 30)
	private String paymentMode;
	private double amount;
	private LocalDateTime dateAndTime;
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;

	@Override
	public String toString() {
		return "Payment [transactionId=" + transactionId + ", booking=" + booking + ", paymentMode=" + paymentMode
				+ ", amount=" + amount + ", dateAndTime=" + dateAndTime + ", transactionStatus=" + transactionStatus
				+ "]";
	}

}

//CLASS FOR CREATING A CUSTOM ID GENERATOR FOR TRANSCATION ID.EX TR_00001
class TransactionIdSequenceGenerator extends SequenceStyleGenerator {
	public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
	public static final String VALUE_PREFIX_DEFAULT = "";
	private String valuePrefix;

	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%d";
	private String numberFormat;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return valuePrefix + String.format(numberFormat, super.generate(session, object));
	}

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws HibernateException {
		super.configure(LongType.INSTANCE, params, serviceRegistry);
		valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params, VALUE_PREFIX_DEFAULT);
		numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT);
	}

}
