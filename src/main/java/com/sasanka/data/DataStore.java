package com.sasanka.data;

/**
 * Hello world!
 *
 */
public class DataStore {
	public static String[] xmlPaths = { "cXML/Header/From/Credential/Identity", "cXML/Header/From/Credential/domain",
			"cXML/Header/To/Credential/Identity", "cXML/Header/To/Credential/domain",
			"cXML/Header/Sender/Credential/Identity", "cXML/Header/Sender/Credential/domain",
			"cXML/Header/Sender/Credential/SharedSecret", "cXML/Header/Sender/UserAgent",
			"cXML/Request/OrderRequest/OrderRequestHeader/orderID",
			"cXML/Request/OrderRequest/OrderRequestHeader/orderDate",
			"cXML/Request/OrderRequest/OrderRequestHeader/type",
			"cXML/Request/OrderRequest/OrderRequestHeader/orderType",
			"cXML/Request/OrderRequest/OrderRequestHeader/orderVersion",
			"cXML/Request/OrderRequest/OrderRequestHeader/Total/currency",
			"cXML/Request/OrderRequest/OrderRequestHeader/Total/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Total/Money/currency",
			"cXML/Request/OrderRequest/OrderRequestHeader/Total/Money/alternateAmount",
			"cXML/Request/OrderRequest/OrderRequestHeader/Total/Money/alternateCurrency",
			"cXML/Request/OrderRequest/OrderRequestHeader/Total/Money/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/addressID",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Name/xml:lang",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Name/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Email/preferredLang",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Email/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Email/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/DeliverTo",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/Delivery",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/Street",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/City",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/State",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/PostalCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/Country/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/PostalAddress/Country/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Phone/TelephoneNumber/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Phone/TelephoneNumber/CountryCode/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Phone/TelephoneNumber/AreaOrCityCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Phone/TelephoneNumber/Number",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Phone/TelephoneNumber/Extension",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Phone/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Fax/TelephoneNumber/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Fax/TelephoneNumber/CountryCode/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Fax/TelephoneNumber/AreaOrCityCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Fax/TelephoneNumber/Number",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Fax/TelephoneNumber/Extension",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/Address/Fax/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/IdReference/domain",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipTo/IdReference/identifier",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/addressID",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Name/xml:lang",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Name/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Name",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Email/preferredLang",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Email/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Email/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/DeliverTo",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/Delivery",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/Street",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/City",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/State",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/PostalCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/Country/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/PostalAddress/Country/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Phone/TelephoneNumber/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Phone/TelephoneNumber/CountryCode/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Phone/TelephoneNumber/AreaOrCityCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Phone/TelephoneNumber/Number",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Phone/TelephoneNumber/Extension",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Phone/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Fax/TelephoneNumber/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Fax/TelephoneNumber/CountryCode/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Fax/TelephoneNumber/AreaOrCityCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Fax/TelephoneNumber/Number",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Fax/TelephoneNumber/Extension",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/Address/Fax/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/IdReference/domain",
			"cXML/Request/OrderRequest/OrderRequestHeader/BillTo/IdReference/identifier",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/addressID",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Name/xml:lang",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Name/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Email/preferredLang",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Email/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Email/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/PostalAddress/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/PostalAddress/DeliverTo",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/PostalAddress/Delivery",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/PostalAddress/Street",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/PostalAddress/City",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/PostalAddress/State",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/PostalAddress/PostalCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/PostalAddress/Country/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/PostalAddress/Country/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Phone/TelephoneNumber/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Phone/TelephoneNumber/CountryCode/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Phone/TelephoneNumber/AreaOrCityCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Phone/TelephoneNumber/Number",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Phone/TelephoneNumber/Extension",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Phone/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Fax/TelephoneNumber/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Fax/TelephoneNumber/CountryCode/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Fax/TelephoneNumber/AreaOrCityCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Fax/TelephoneNumber/Number",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Fax/TelephoneNumber/Extension",
			"cXML/Request/OrderRequest/OrderRequestHeader/ShipFrom/Address/Fax/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/Shipping/Money/currency",
			"cXML/Request/OrderRequest/OrderRequestHeader/Shipping/Money/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Shipping/Description/xml:lang",
			"cXML/Request/OrderRequest/OrderRequestHeader/Shipping/Description/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/Money/currency",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/Money/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/Description/xml:lang",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/Description/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/TaxDetail/TaxableAmount/Money/currency",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/TaxDetail/TaxableAmount/Money/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/TaxDetail/TaxAmount/Money/currency",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/TaxDetail/TaxAmount/Money/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/TaxDetail/Description/xml:lang",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/TaxDetail/Description/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/TaxDetail/category",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/TaxDetail/percentageRate",
			"cXML/Request/OrderRequest/OrderRequestHeader/Tax/TaxDetail/purpose",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/role",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/addressID",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/addressIDDomain",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Name/xml:lang",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Name/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Email/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Email/preferredLang",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Email/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/PostalAddress/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/PostalAddress/DeliverTo",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/PostalAddress/Street",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/PostalAddress/City",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/PostalAddress/State",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/PostalAddress/PostalCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/PostalAddress/Country/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/PostalAddress/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/PostalAddress/Country/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/PostalAddress/CountryCode/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Phone/TelephoneNumber/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Phone/TelephoneNumber/CountryCode/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Phone/TelephoneNumber/AreaOrCityCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Phone/TelephoneNumber/Number",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Phone/TelephoneNumber/Extension",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Phone/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Fax/TelephoneNumber/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Fax/TelephoneNumber/CountryCode/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Fax/TelephoneNumber/AreaOrCityCode",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Fax/TelephoneNumber/Number",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Fax/TelephoneNumber/Extension",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Fax/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/IdReference/domain",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/IdReference/identifier",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Extrinsic/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/Contact/Extrinsic/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/Extrinsic/Credential/Identity",
			"cXML/Request/OrderRequest/OrderRequestHeader/Extrinsic/Credential/domain",
			"cXML/Request/OrderRequest/OrderRequestHeader/Extrinsic/name",
			"cXML/Request/OrderRequest/OrderRequestHeader/Extrinsic/content",
			"cXML/Request/OrderRequest/OrderRequestHeader/PaymentTerm/payInNumberOfDays",
			"cXML/Request/OrderRequest/OrderRequestHeader/Comments", "cXML/Request/OrderRequest/ItemOut/Comments",
			"cXML/Request/OrderRequest/ItemOut/quantity", "cXML/Request/OrderRequest/ItemOut/requisitionID",
			"cXML/Request/OrderRequest/ItemOut/lineNumber", "cXML/Request/OrderRequest/ItemOut/ItemID/SupplierPartID",
			"cXML/Request/OrderRequest/ItemOut/ItemID/SupplierPartAuxiliaryID",
			"cXML/Request/OrderRequest/ItemOut/ItemID/BuyerPartID",
			"cXML/Request/OrderRequest/ItemOut/ItemID/Extrinsic/name",
			"cXML/Request/OrderRequest/ItemOut/ItemID/Extrinsic/content",
			"cXML/Request/OrderRequest/ItemOut/Extrinsic/name", "cXML/Request/OrderRequest/ItemOut/Extrinsic/content",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/UnitPrice/Money/currency",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/UnitPrice/Money/content",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/UnitPrice/Money",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/Description/xml:lang",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/Description/content",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/UnitOfMeasure",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/Classification/domain",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/Classification/content",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/ManufacturerPartID",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/ManufacturerName/xml:lang",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/ManufacturerName/content",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/ManufacturerName",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/Extrinsic/Credential/Identity",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/Extrinsic/Credential/domain",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/Extrinsic/name",
			"cXML/Request/OrderRequest/ItemOut/ItemDetail/Extrinsic/content",
			"cXML/Request/OrderRequest/ItemOut/Distribution/Accounting/name",
			"cXML/Request/OrderRequest/ItemOut/Distribution/Accounting/AccountingSegment/id",
			"cXML/Request/OrderRequest/ItemOut/Distribution/Accounting/AccountingSegment/Name/xml:lang",
			"cXML/Request/OrderRequest/ItemOut/Distribution/Accounting/AccountingSegment/Name/content",
			"cXML/Request/OrderRequest/ItemOut/Distribution/Accounting/AccountingSegment/Description/xml:lang",
			"cXML/Request/OrderRequest/ItemOut/Distribution/Accounting/AccountingSegment/Description/content",
			"cXML/Request/OrderRequest/ItemOut/Distribution/Charge/Money/currency",
			"cXML/Request/OrderRequest/ItemOut/Distribution/Charge/Money/content",
			"cXML/Request/OrderRequest/ItemOut/Contact/role", "cXML/Request/OrderRequest/ItemOut/Contact/addressID",
			"cXML/Request/OrderRequest/ItemOut/Contact/addressIDDomain",
			"cXML/Request/OrderRequest/ItemOut/Contact/Name/xml:lang",
			"cXML/Request/OrderRequest/ItemOut/Contact/Name/content",
			"cXML/Request/OrderRequest/ItemOut/Contact/PostalAddress/Street",
			"cXML/Request/OrderRequest/ItemOut/Contact/PostalAddress/City",
			"cXML/Request/OrderRequest/ItemOut/Contact/PostalAddress/State",
			"cXML/Request/OrderRequest/ItemOut/Contact/PostalAddress/PostalCode",
			"cXML/Request/OrderRequest/ItemOut/Contact/PostalAddress/Country/isoCountryCode",
			"cXML/Request/OrderRequest/ItemOut/Contact/PostalAddress/Country/content",
			"cXML/Request/OrderRequest/ItemOut/ControlKeys/ASNInstruction/value",
			"cXML/Request/OrderRequest/ItemOut/ControlKeys/InvoiceInstruction/value",
			"cXML/Request/OrderRequest/ItemOut/ScheduleLine/quantity",
			"cXML/Request/OrderRequest/ItemOut/ScheduleLine/requestedDeliveryDate",
			"cXML/Request/OrderRequest/ItemOut/ScheduleLine/lineNumber",
			"cXML/Request/OrderRequest/ItemOut/ScheduleLine/UnitOfMeasure",
			"cXML/Request/OrderRequest/ItemOut/SupplierID/domain",
			"cXML/Request/OrderRequest/ItemOut/SupplierID/content",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/isoCountryCode",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/addressID",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/addressIDDomain",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Name/xml:lang",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Name/content",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/PostalAddress/name",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/PostalAddress/DeliverTo",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/PostalAddress/Street",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/PostalAddress/City",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/PostalAddress/State",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/PostalAddress/PostalCode",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/PostalAddress/Country/isoCountryCode",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/PostalAddress/Country/content",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Email",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Phone/TelephoneNumber/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Phone/TelephoneNumber/AreaOrCityCode",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Phone/TelephoneNumber/Number",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Phone/TelephoneNumber/Extension",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Phone/name",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Fax/TelephoneNumber/CountryCode/isoCountryCode",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Fax/TelephoneNumber/AreaOrCityCode",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Fax/TelephoneNumber/Number",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Fax/TelephoneNumber/Extension",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/Address/Fax/name",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/IdReference/domain",
			"cXML/Request/OrderRequest/ItemOut/ShipTo/IdReference/identifier",
			"cXML/Request/OrderRequest/ItemOut/Shipping/Money/currency",
			"cXML/Request/OrderRequest/ItemOut/Shipping/Money/content",
			"cXML/Request/OrderRequest/ItemOut/Shipping/Description/xml:lang",
			"cXML/Request/OrderRequest/ItemOut/Shipping/Description/content",
			"cXML/Request/OrderRequest/ItemOut/Tax/Money/currency",
			"cXML/Request/OrderRequest/ItemOut/Tax/Money/content",
			"cXML/Request/OrderRequest/ItemOut/Tax/Description/xml:lang",
			"cXML/Request/OrderRequest/ItemOut/Tax/Description/content",
			"cXML/Request/OrderRequest/ItemOut/Tax/TaxDetail/TaxableAmount/Money/currency",
			"cXML/Request/OrderRequest/ItemOut/Tax/TaxDetail/TaxableAmount/Money/content",
			"cXML/Request/OrderRequest/ItemOut/Tax/TaxDetail/TaxAmount/Money/currency",
			"cXML/Request/OrderRequest/ItemOut/Tax/TaxDetail/TaxAmount/Money/content",
			"cXML/Request/OrderRequest/ItemOut/Tax/TaxDetail/Description/xml:lang",
			"cXML/Request/OrderRequest/ItemOut/Tax/TaxDetail/Description/content",
			"cXML/Request/OrderRequest/ItemOut/Tax/TaxDetail/category",
			"cXML/Request/OrderRequest/ItemOut/Tax/TaxDetail/percentageRate",
			"cXML/Request/OrderRequest/ItemOut/Tax/TaxDetail/purpose", "cXML/Request/deploymentMode", "cXML/version",
			"cXML/payloadID", "cXML/timestamp", "cXML/xml:lang" };

	public static String[] ciwxmlPaths = { "ciw_xml_flag", "PurchaseOrder/Header/language_id", "domain",
			"PurchaseOrder/account_name", "PurchaseOrder/ACCOUNT_NAME", "PurchaseOrder/Routing/SenderID",
			"PurchaseOrder/Routing/ReceiverID", "PurchaseOrder/Header/po_amount", "PurchaseOrder/Header/po_id",
			"PurchaseOrder/Header/account_id", "PurchaseOrder/Header/status_code_id",
			"PurchaseOrder/Header/po_type", "PurchaseOrder/Header/po_purpose",
			"PurchaseOrder/Header/po_number", "PurchaseOrder/Header/release_number",
			"PurchaseOrder/Header/blanket_id", "PurchaseOrder/Header/po_date",
			"PurchaseOrder/Header/doms_po_number", "PurchaseOrder/Header/terms_code",
			"PurchaseOrder/Header/terms_basis_code", "PurchaseOrder/Header/terms_discount",
			"PurchaseOrder/Header/terms_discount_date", "PurchaseOrder/Header/terms_discount_days",
			"PurchaseOrder/Header/terms_net_days", "PurchaseOrder/Header/terms_day_of_month",
			"PurchaseOrder/Header/po_received_date", "PurchaseOrder/Header/po_confirmed_date",
			"PurchaseOrder/Header/fob_payment_method", "PurchaseOrder/Header/fob_location_id",
			"PurchaseOrder/Header/fob_location_descr", "PurchaseOrder/Header/key_code",
			"PurchaseOrder/Header/currency_id", "PurchaseOrder/Header/isa_control_number",
			"PurchaseOrder/Header/gs_control_number", "PurchaseOrder/Header/st_control_number",
			"PurchaseOrder/Header/translate_date", "PurchaseOrder/Header/source",
			"PurchaseOrder/Header/exchange_rate", "PurchaseOrder/Header/exchange_currency_id",
			"PurchaseOrder/Header/target_ship_date", "PurchaseOrder/Header/target_ship_code",
			"PurchaseOrder/Header/shipping_service", "PurchaseOrder/Header/shipping_payment_terms",
			"PurchaseOrder/Header/shipping_carrier", "PurchaseOrder/Header/shipping_account_number",
			"PurchaseOrder/Header/requested_ship_date", "PurchaseOrder/Header/shipping_charge",
			"PurchaseOrder/Header/tax_exempt_code", "PurchaseOrder/Header/tax_id_number",
			"PurchaseOrder/Header/aoe_customer_id", "PurchaseOrder/Header/sales_rep_id",
			"PurchaseOrder/Header/modified", "PurchaseOrder/Header/modified_by",
			"PurchaseOrder/Header/modifed_reason", "PurchaseOrder/Header/blanket_po_expiration_date",
			"PurchaseOrder/Header/blanket_po_effective_date", "PurchaseOrder/Header/contract_expiration_date",
			"PurchaseOrder/Header/contract_effective_date", "PurchaseOrder/Header/contract_number",
			"PurchaseOrder/Header/requested_delivery_date", "PurchaseOrder/Header/locked_by",
			"PurchaseOrder/Header/locked_datetime", "PurchaseOrder/Header/locked_reason",
			"PurchaseOrder/Header/status_code", "PurchaseOrder/Header/communicated",
			"PurchaseOrder/Header/cxml_version", "PurchaseOrder/Header/cxml_timestamp",
			"PurchaseOrder/Header/cxml_payload", "PurchaseOrder/Header/to_domain",
			"PurchaseOrder/Header/to_identity", "PurchaseOrder/Header/sender_domain",
			"PurchaseOrder/Header/sender_identity", "PurchaseOrder/Header/sender_shared_secret",
			"PurchaseOrder/Header/sender_user_agent", "PurchaseOrder/Header/HeaderCustom/custom_label",
			"PurchaseOrder/Header/HeaderCustom/custom_value", "PurchaseOrder/Header/HeaderCustom/custom_id",
			"PurchaseOrder/Header/HeaderCustom/parent_table", "PurchaseOrder/Header/HeaderCustom/parent_id",
			"PurchaseOrder/Header/HeaderCustom/custom_type", "PurchaseOrder/Header/HeaderCustom/custom_level",
			"PurchaseOrder/Header/HeaderCustom/custom_sequence",
			"PurchaseOrder/Header/HeaderCustom/usage_indicator", "PurchaseOrder/Header/HeaderCustom/modified",
			"PurchaseOrder/Header/HeaderCustom/modified_by", "PurchaseOrder/Header/HeaderCustom/modified_reason",
			"PurchaseOrder/Header/HeaderCustom/custom_label_qualifier",
			"PurchaseOrder/Header/HeaderCustom/custom_value_qualifier",
			"PurchaseOrder/Header/ShipTo/address_type", "PurchaseOrder/Header/ShipTo/address_id",
			"PurchaseOrder/Header/ShipTo/parent_table", "PurchaseOrder/Header/ShipTo/parent_id",
			"PurchaseOrder/Header/ShipTo/account_id", "PurchaseOrder/Header/ShipTo/address_name",
			"PurchaseOrder/Header/ShipTo/streets", "PurchaseOrder/Header/ShipTo/address_names",
			"PurchaseOrder/Header/ShipTo/address_city", "PurchaseOrder/Header/ShipTo/address_state",
			"PurchaseOrder/Header/ShipTo/address_zip", "PurchaseOrder/Header/ShipTo/address_country",
			"PurchaseOrder/Header/ShipTo/modified", "PurchaseOrder/Header/ShipTo/modified_by",
			"PurchaseOrder/Header/ShipTo/modified_reason",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/modified",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/ShipTo/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/ShipTo/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/BillTo/address_type", "PurchaseOrder/Header/BillTo/address_id",
			"PurchaseOrder/Header/BillTo/parent_table", "PurchaseOrder/Header/BillTo/parent_id",
			"PurchaseOrder/Header/BillTo/account_id", "PurchaseOrder/Header/BillTo/address_name",
			"PurchaseOrder/Header/BillTo/streets", "PurchaseOrder/Header/BillTo/address_names",
			"PurchaseOrder/Header/BillTo/address_city", "PurchaseOrder/Header/BillTo/address_state",
			"PurchaseOrder/Header/BillTo/address_zip", "PurchaseOrder/Header/BillTo/address_country",
			"PurchaseOrder/Header/BillTo/modified", "PurchaseOrder/Header/BillTo/modified_by",
			"PurchaseOrder/Header/BillTo/modified_reason",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/modified",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/BillTo/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/BillTo/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/ShipFrom/address_type", "PurchaseOrder/Header/ShipFrom/address_id",
			"PurchaseOrder/Header/ShipFrom/parent_table", "PurchaseOrder/Header/ShipFrom/parent_id",
			"PurchaseOrder/Header/ShipFrom/account_id", "PurchaseOrder/Header/ShipFrom/address_name",
			"PurchaseOrder/Header/ShipFrom/streets", "PurchaseOrder/Header/ShipFrom/address_names",
			"PurchaseOrder/Header/ShipFrom/address_city", "PurchaseOrder/Header/ShipFrom/address_state",
			"PurchaseOrder/Header/ShipFrom/address_zip", "PurchaseOrder/Header/ShipFrom/address_country",
			"PurchaseOrder/Header/ShipFrom/modified", "PurchaseOrder/Header/ShipFrom/modified_by",
			"PurchaseOrder/Header/ShipFrom/modified_reason",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/modified",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/ShipFrom/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/SoldTo/address_type", "PurchaseOrder/Header/SoldTo/address_id",
			"PurchaseOrder/Header/SoldTo/parent_table", "PurchaseOrder/Header/SoldTo/parent_id",
			"PurchaseOrder/Header/SoldTo/account_id", "PurchaseOrder/Header/SoldTo/address_name",
			"PurchaseOrder/Header/SoldTo/streets", "PurchaseOrder/Header/SoldTo/address_names",
			"PurchaseOrder/Header/SoldTo/address_city", "PurchaseOrder/Header/SoldTo/address_state",
			"PurchaseOrder/Header/SoldTo/address_zip", "PurchaseOrder/Header/SoldTo/address_country",
			"PurchaseOrder/Header/SoldTo/modified", "PurchaseOrder/Header/SoldTo/modified_by",
			"PurchaseOrder/Header/SoldTo/modified_reason",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/modified",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/SoldTo/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/SoldTo/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/RemitTo/address_type", "PurchaseOrder/Header/RemitTo/address_id",
			"PurchaseOrder/Header/RemitTo/parent_table", "PurchaseOrder/Header/RemitTo/parent_id",
			"PurchaseOrder/Header/RemitTo/account_id", "PurchaseOrder/Header/RemitTo/address_name",
			"PurchaseOrder/Header/RemitTo/streets", "PurchaseOrder/Header/RemitTo/address_names",
			"PurchaseOrder/Header/RemitTo/address_city", "PurchaseOrder/Header/RemitTo/address_state",
			"PurchaseOrder/Header/RemitTo/address_zip", "PurchaseOrder/Header/RemitTo/address_country",
			"PurchaseOrder/Header/RemitTo/modified", "PurchaseOrder/Header/RemitTo/modified_by",
			"PurchaseOrder/Header/RemitTo/modified_reason",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/modified",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/RemitTo/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/RemitTo/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/Buyer/address_type", "PurchaseOrder/Header/Buyer/address_id",
			"PurchaseOrder/Header/Buyer/parent_table", "PurchaseOrder/Header/Buyer/parent_id",
			"PurchaseOrder/Header/Buyer/account_id", "PurchaseOrder/Header/Buyer/address_name",
			"PurchaseOrder/Header/Buyer/streets", "PurchaseOrder/Header/Buyer/address_names",
			"PurchaseOrder/Header/Buyer/address_city", "PurchaseOrder/Header/Buyer/address_state",
			"PurchaseOrder/Header/Buyer/address_zip", "PurchaseOrder/Header/Buyer/address_country",
			"PurchaseOrder/Header/Buyer/modified", "PurchaseOrder/Header/Buyer/modified_by",
			"PurchaseOrder/Header/Buyer/modified_reason",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/modified",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/Buyer/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/Buyer/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/Seller/address_type", "PurchaseOrder/Header/Seller/address_id",
			"PurchaseOrder/Header/Seller/parent_table", "PurchaseOrder/Header/Seller/parent_id",
			"PurchaseOrder/Header/Seller/account_id", "PurchaseOrder/Header/Seller/address_name",
			"PurchaseOrder/Header/Seller/streets", "PurchaseOrder/Header/Seller/address_names",
			"PurchaseOrder/Header/Seller/address_city", "PurchaseOrder/Header/Seller/address_state",
			"PurchaseOrder/Header/Seller/address_zip", "PurchaseOrder/Header/Seller/address_country",
			"PurchaseOrder/Header/Seller/modified", "PurchaseOrder/Header/Seller/modified_by",
			"PurchaseOrder/Header/Seller/modified_reason",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/modified",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/Seller/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/Seller/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/ResaleDealer/address_type", "PurchaseOrder/Header/ResaleDealer/address_id",
			"PurchaseOrder/Header/ResaleDealer/parent_table", "PurchaseOrder/Header/ResaleDealer/parent_id",
			"PurchaseOrder/Header/ResaleDealer/account_id", "PurchaseOrder/Header/ResaleDealer/address_name",
			"PurchaseOrder/Header/ResaleDealer/streets", "PurchaseOrder/Header/ResaleDealer/address_names",
			"PurchaseOrder/Header/ResaleDealer/address_city", "PurchaseOrder/Header/ResaleDealer/address_state",
			"PurchaseOrder/Header/ResaleDealer/address_zip", "PurchaseOrder/Header/ResaleDealer/address_country",
			"PurchaseOrder/Header/ResaleDealer/modified", "PurchaseOrder/Header/ResaleDealer/modified_by",
			"PurchaseOrder/Header/ResaleDealer/modified_reason",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/modified",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/ResaleDealer/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/EndUser/address_type", "PurchaseOrder/Header/EndUser/address_id",
			"PurchaseOrder/Header/EndUser/parent_table", "PurchaseOrder/Header/EndUser/parent_id",
			"PurchaseOrder/Header/EndUser/account_id", "PurchaseOrder/Header/EndUser/address_name",
			"PurchaseOrder/Header/EndUser/streets", "PurchaseOrder/Header/EndUser/address_names",
			"PurchaseOrder/Header/EndUser/address_city", "PurchaseOrder/Header/EndUser/address_state",
			"PurchaseOrder/Header/EndUser/address_zip", "PurchaseOrder/Header/EndUser/address_country",
			"PurchaseOrder/Header/EndUser/modified", "PurchaseOrder/Header/EndUser/modified_by",
			"PurchaseOrder/Header/EndUser/modified_reason",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/modified",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/EndUser/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/EndUser/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/Vendor/address_type", "PurchaseOrder/Header/Vendor/address_id",
			"PurchaseOrder/Header/Vendor/parent_table", "PurchaseOrder/Header/Vendor/parent_id",
			"PurchaseOrder/Header/Vendor/account_id", "PurchaseOrder/Header/Vendor/address_name",
			"PurchaseOrder/Header/Vendor/streets", "PurchaseOrder/Header/Vendor/address_names",
			"PurchaseOrder/Header/Vendor/address_city", "PurchaseOrder/Header/Vendor/address_state",
			"PurchaseOrder/Header/Vendor/address_zip", "PurchaseOrder/Header/Vendor/address_country",
			"PurchaseOrder/Header/Vendor/modified", "PurchaseOrder/Header/Vendor/modified_by",
			"PurchaseOrder/Header/Vendor/modified_reason",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/modified",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/Vendor/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/Vendor/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/ContactAddress/address_type", "PurchaseOrder/Header/ContactAddress/address_id",
			"PurchaseOrder/Header/ContactAddress/parent_table", "PurchaseOrder/Header/ContactAddress/parent_id",
			"PurchaseOrder/Header/ContactAddress/account_id", "PurchaseOrder/Header/ContactAddress/address_name",
			"PurchaseOrder/Header/ContactAddress/streets", "PurchaseOrder/Header/ContactAddress/address_names",
			"PurchaseOrder/Header/ContactAddress/address_city",
			"PurchaseOrder/Header/ContactAddress/address_state",
			"PurchaseOrder/Header/ContactAddress/address_zip",
			"PurchaseOrder/Header/ContactAddress/address_country", "PurchaseOrder/Header/ContactAddress/modified",
			"PurchaseOrder/Header/ContactAddress/modified_by",
			"PurchaseOrder/Header/ContactAddress/modified_reason",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/modified",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/ContactAddress/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/OrderedBy/address_type", "PurchaseOrder/Header/OrderedBy/address_id",
			"PurchaseOrder/Header/OrderedBy/parent_table", "PurchaseOrder/Header/OrderedBy/parent_id",
			"PurchaseOrder/Header/OrderedBy/account_id", "PurchaseOrder/Header/OrderedBy/address_name",
			"PurchaseOrder/Header/OrderedBy/streets", "PurchaseOrder/Header/OrderedBy/address_names",
			"PurchaseOrder/Header/OrderedBy/address_city", "PurchaseOrder/Header/OrderedBy/address_state",
			"PurchaseOrder/Header/OrderedBy/address_zip", "PurchaseOrder/Header/OrderedBy/address_country",
			"PurchaseOrder/Header/OrderedBy/modified", "PurchaseOrder/Header/OrderedBy/modified_by",
			"PurchaseOrder/Header/OrderedBy/modified_reason",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/contact_id",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/parent_table",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/parent_id",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/contact_name",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/contact_type",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/modified",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/modified_by",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/modified_reason",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/contact_phone",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/contact_fax",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressContact/contact_email",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/custom_label",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/custom_value",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/custom_id",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/parent_table",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/parent_id",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/custom_type",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/custom_level",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/custom_sequence",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/usage_indicator",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/modified",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/modified_by",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/modified_reason",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Header/OrderedBy/HeaderAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Header/HeaderContact/contact_id", "PurchaseOrder/Header/HeaderContact/parent_table",
			"PurchaseOrder/Header/HeaderContact/parent_id", "PurchaseOrder/Header/HeaderContact/contact_name",
			"PurchaseOrder/Header/HeaderContact/contact_phone", "PurchaseOrder/Header/HeaderContact/contact_fax",
			"PurchaseOrder/Header/HeaderContact/contact_email", "PurchaseOrder/Header/HeaderContact/contact_type",
			"PurchaseOrder/Header/HeaderContact/modified", "PurchaseOrder/Header/HeaderContact/modified_by",
			"PurchaseOrder/Header/HeaderContact/modified_reason", "PurchaseOrder/Detail/po_detail_id",
			"PurchaseOrder/Detail/parent_detail_id", "PurchaseOrder/Detail/po_id",
			"PurchaseOrder/Detail/catalog_id", "PurchaseOrder/Detail/po_line_number",
			"PurchaseOrder/Detail/qty_ordered", "PurchaseOrder/Detail/unit_of_measure",
			"PurchaseOrder/Detail/unit_price", "PurchaseOrder/Detail/customer_item_number",
			"PurchaseOrder/Detail/requested_delivery_date", "PurchaseOrder/Detail/quote_number",
			"PurchaseOrder/Detail/doms_order_number", "PurchaseOrder/Detail/requested_ship_date",
			"PurchaseOrder/Detail/po_line_sequence", "PurchaseOrder/Detail/terms_code",
			"PurchaseOrder/Detail/terms_basis_code", "PurchaseOrder/Detail/terms_discount",
			"PurchaseOrder/Detail/terms_discount_date", "PurchaseOrder/Detail/terms_discount_days",
			"PurchaseOrder/Detail/terms_net_days", "PurchaseOrder/Detail/terms_day_of_month",
			"PurchaseOrder/Detail/fob_payment_method", "PurchaseOrder/Detail/fob_location_id",
			"PurchaseOrder/Detail/fob_location_descr", "PurchaseOrder/Detail/tax_exempt_code",
			"PurchaseOrder/Detail/tax_id_number", "PurchaseOrder/Detail/shipping_service",
			"PurchaseOrder/Detail/shipping_payment_terms", "PurchaseOrder/Detail/shipping_carrier",
			"PurchaseOrder/Detail/shipping_account_number", "PurchaseOrder/Detail/modified",
			"PurchaseOrder/Detail/modified_by", "PurchaseOrder/Detail/modified_reason",
			"PurchaseOrder/Detail/DetailDescription/po_detail_descr_id",
			"PurchaseOrder/Detail/DetailDescription/po_detail_id",
			"PurchaseOrder/Detail/DetailDescription/descr_sequence",
			"PurchaseOrder/Detail/DetailDescription/modified",
			"PurchaseOrder/Detail/DetailDescription/modified_by",
			"PurchaseOrder/Detail/DetailDescription/modified_reason",
			"PurchaseOrder/Detail/DetailDescription/descr", "PurchaseOrder/Detail/DetailCustom/custom_id",
			"PurchaseOrder/Detail/DetailCustom/parent_table", "PurchaseOrder/Detail/DetailCustom/parent_id",
			"PurchaseOrder/Detail/DetailCustom/custom_type", "PurchaseOrder/Detail/DetailCustom/custom_level",
			"PurchaseOrder/Detail/DetailCustom/custom_label", "PurchaseOrder/Detail/DetailCustom/custom_value",
			"PurchaseOrder/Detail/DetailCustom/custom_sequence",
			"PurchaseOrder/Detail/DetailCustom/usage_indicator", "PurchaseOrder/Detail/DetailCustom/modified",
			"PurchaseOrder/Detail/DetailCustom/modified_by", "PurchaseOrder/Detail/DetailCustom/modified_reason",
			"PurchaseOrder/Detail/DetailCustom/custom_label_qualifier",
			"PurchaseOrder/Detail/DetailCustom/custom_value_qualifier",
			"PurchaseOrder/Detail/DetailAddress/address_id", "PurchaseOrder/Detail/DetailAddress/parent_table",
			"PurchaseOrder/Detail/DetailAddress/parent_id", "PurchaseOrder/Detail/DetailAddress/address_type",
			"PurchaseOrder/Detail/DetailAddress/account_id", "PurchaseOrder/Detail/DetailAddress/address_name",
			"PurchaseOrder/Detail/DetailAddress/address_name2",
			"PurchaseOrder/Detail/DetailAddress/address_name3",
			"PurchaseOrder/Detail/DetailAddress/address_line_1",
			"PurchaseOrder/Detail/DetailAddress/address_line_2",
			"PurchaseOrder/Detail/DetailAddress/address_city", "PurchaseOrder/Detail/DetailAddress/address_state",
			"PurchaseOrder/Detail/DetailAddress/address_zip",
			"PurchaseOrder/Detail/DetailAddress/address_country", "PurchaseOrder/Detail/DetailAddress/modified",
			"PurchaseOrder/Detail/DetailAddress/modified_by",
			"PurchaseOrder/Detail/DetailAddress/modified_reason",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/contact_id",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/parent_table",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/parent_id",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/contact_name",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/contact_type",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/modified",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/modified_by",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/modified_reason",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/contact_phone",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/contact_fax",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressContact/contact_email",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/custom_label",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/custom_value",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/custom_id",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/parent_table",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/parent_id",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/custom_type",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/custom_level",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/custom_sequence",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/usage_indicator",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/modified",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/modified_by",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/modified_reason",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/custom_label_qualifier",
			"PurchaseOrder/Detail/DetailAddress/DetailAddressCustom/custom_value_qualifier",
			"PurchaseOrder/Detail/DetailOption/invoice_detail_option_id",
			"PurchaseOrder/Detail/DetailOption/invoice_detail_id", "PurchaseOrder/Detail/DetailOption/option_qty",
			"PurchaseOrder/Detail/DetailOption/option_sku", "PurchaseOrder/Detail/DetailOption/option_unit_price",
			"PurchaseOrder/Detail/DetailOption/option_descr", "PurchaseOrder/Detail/DetailOption/option_type",
			"PurchaseOrder/Detail/DetailOption/option_action",
			"PurchaseOrder/Detail/DetailOption/configuration_code", "PurchaseOrder/Detail/DetailOption/modified",
			"PurchaseOrder/Detail/DetailOption/modified_by", "PurchaseOrder/Detail/DetailOption/modified_reason",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/custom_id",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/parent_table",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/parent_id",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/custom_type",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/custom_level",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/custom_label",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/custom_value",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/custom_sequence",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/usage_indicator",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/modified",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/modified_by",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/modified_reason",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/custom_label_qualifier",
			"PurchaseOrder/Detail/DetailOption/DetailOptionCustom/custom_value_qualifier",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/shipment_id",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/parent_table",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/parent_id",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/waybill_number",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/carrier",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/box_count",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/shipping_service",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/mode_of_transport",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/ship_date",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/pod_name",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/pod_date",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/modified",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/modified_by",
			"PurchaseOrder/Detail/DetailOption/DetailOptionShipment/modified_reason",
			"PurchaseOrder/Detail/DetailShipment/shipment_id", "PurchaseOrder/Detail/DetailShipment/parent_table",
			"PurchaseOrder/Detail/DetailShipment/parent_id", "PurchaseOrder/Detail/DetailShipment/waybill_number",
			"PurchaseOrder/Detail/DetailShipment/carrier", "PurchaseOrder/Detail/DetailShipment/box_count",
			"PurchaseOrder/Detail/DetailShipment/shipping_service",
			"PurchaseOrder/Detail/DetailShipment/mode_of_transport",
			"PurchaseOrder/Detail/DetailShipment/ship_date", "PurchaseOrder/Detail/DetailShipment/pod_name",
			"PurchaseOrder/Detail/DetailShipment/pod_date", "PurchaseOrder/Detail/DetailShipment/modified",
			"PurchaseOrder/Detail/DetailShipment/modified_by",
			"PurchaseOrder/Detail/DetailShipment/modified_reason",
			"PurchaseOrder/Detail/DetailItem/invoice_detail_item_id",
			"PurchaseOrder/Detail/DetailItem/invoice_detail_item_parent_id",
			"PurchaseOrder/Detail/DetailItem/invoice_detail_id", "PurchaseOrder/Detail/DetailItem/item_number",
			"PurchaseOrder/Detail/DetailItem/item_description", "PurchaseOrder/Detail/DetailItem/asset_tag",
			"PurchaseOrder/Detail/DetailItem/service_tag", "PurchaseOrder/Detail/DetailItem/asset_tag_parent",
			"PurchaseOrder/Detail/DetailItem/asset_type", "PurchaseOrder/Detail/DetailItem/asset_relation",
			"PurchaseOrder/Detail/DetailItem/manufacturer", "PurchaseOrder/Detail/DetailItem/configuration_code",
			"PurchaseOrder/Detail/DetailItem/modified", "PurchaseOrder/Detail/DetailItem/order_group_number",
			"PurchaseOrder/Detail/DetailItem/item_type_ind", "PurchaseOrder/Detail/DetailItem/modified_by",
			"PurchaseOrder/Detail/DetailItem/modified_reason" };
	
	
	public static String xslt_cxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
    		+ "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\r\n"
    		+ "    <xsl:output method=\"xml\" indent=\"yes\"/>\r\n"
    		+ "    \r\n"
    		+ "    <xsl:template match=\"/\">\r\n"
    		+ "        <cXML version=\"1.2.007\">\r\n"
    		+ "            <Header>\r\n"
    		+ "                <From>\r\n"
    		+ "                    <Credential>\r\n"
    		+ "                        <Identity>\r\n"
    		+ "                            <xsl:value-of select=\"/PurchaseOrder/OrderHeader/OrderParty/BuyerParty/ListOfIdentifier/Identifier/Agency/@AgencyOther\"/>\r\n"
    		+ "                        </Identity>\r\n"
    		+ "                    </Credential>\r\n"
    		+ "                </From>\r\n"
    		+ "                <To>\r\n"
    		+ "                    <Credential>\r\n"
    		+ "                        <Identity>\r\n"
    		+ "                            <xsl:value-of select=\"/PurchaseOrder/OrderHeader/OrderParty/SupplierParty/@PartyID\"/>\r\n"
    		+ "                        </Identity>\r\n"
    		+ "                    </Credential>\r\n"
    		+ "                </To>\r\n"
    		+ "                <Sender>\r\n"
    		+ "                    <Credential>\r\n"
    		+ "                        <Identity>\r\n"
    		+ "                            <xsl:value-of select=\"/PurchaseOrder/OrderHeader/OrderParty/BuyerParty/ListOfIdentifier/Identifier/Agency/@AgencyID\"/>\r\n"
    		+ "                        </Identity>\r\n"
    		+ "                        <SharedSecret>\r\n"
    		+ "                            <xsl:value-of select=\"/PurchaseOrder/OrderHeader/OrderParty/BuyerParty/ListOfIdentifier/Identifier/Agency/@AgencyOther\"/>\r\n"
    		+ "                        </SharedSecret>\r\n"
    		+ "                    </Credential>\r\n"
    		+ "                </Sender>\r\n"
    		+ "            </Header>\r\n"
    		+ "            <Request>\r\n"
    		+ "                <OrderRequest>\r\n"
    		+ "                    <OrderRequestHeader orderID=\"{/PurchaseOrder/OrderHeader/OrderReference/BuyerRefNum/Reference/RefNum}\" orderDate=\"{/PurchaseOrder/OrderHeader/POIssuedDate}\" type=\"new\" orderType=\"regular\">\r\n"
    		+ "                        <Total>\r\n"
    		+ "                            <Money>\r\n"
    		+ "                                <xsl:value-of select=\"/PurchaseOrder/OrderSummary/TotalAmount\"/>\r\n"
    		+ "                            </Money>\r\n"
    		+ "                        </Total>\r\n"
    		+ "                        <ShipTo>\r\n"
    		+ "                            <Address>\r\n"
    		+ "                                <PostalAddress>\r\n"
    		+ "                                    <DeliverTo>\r\n"
    		+ "                                        <xsl:value-of select=\"/PurchaseOrder/OrderHeader/OrderParty/BuyerParty/OrderContact/ContactName\"/>\r\n"
    		+ "                                    </DeliverTo>\r\n"
    		+ "                                    <Country>\r\n"
    		+ "                                        <xsl:value-of select=\"/PurchaseOrder/OrderHeader/OrderParty/ShipToParty/NameAddress/Country\"/>\r\n"
    		+ "                                    </Country>\r\n"
    		+ "                                </PostalAddress>\r\n"
    		+ "                                <Email>\r\n"
    		+ "                                    <xsl:value-of select=\"/PurchaseOrder/OrderHeader/OrderParty/BuyerParty/OrderContact/Email\"/>\r\n"
    		+ "                                </Email>\r\n"
    		+ "                                <Phone>\r\n"
    		+ "                                    <TelephoneNumber>\r\n"
    		+ "                                        <CountryCode>\r\n"
    		+ "                                            <xsl:value-of select=\"/PurchaseOrder/OrderHeader/OrderParty/ShipToParty/NameAddress/Country\"/>\r\n"
    		+ "                                        </CountryCode>\r\n"
    		+ "                                    </TelephoneNumber>\r\n"
    		+ "                                </Phone>\r\n"
    		+ "                            </Address>\r\n"
    		+ "                        </ShipTo>\r\n"
    		+ "                        <BillTo>\r\n"
    		+ "                            <Address>\r\n"
    		+ "                                <PostalAddress>\r\n"
    		+ "                                    <Country>\r\n"
    		+ "                                        <xsl:value-of select=\"/PurchaseOrder/OrderHeader/OrderParty/BillToParty/NameAddress/Country\"/>\r\n"
    		+ "                                    </Country>\r\n"
    		+ "                                </PostalAddress>\r\n"
    		+ "                            </Address>\r\n"
    		+ "                        </BillTo>\r\n"
    		+ "                    </OrderRequestHeader>\r\n"
    		+ "                    <xsl:for-each select=\"/PurchaseOrder/ListOfOrderDetail/OrderDetail\">\r\n"
    		+ "                        <ItemOut quantity=\"{BaseItemDetail/Quantity/Qty}\" requestedDeliveryDate=\"{RequestedDeliveryDate}\" lineNumber=\"{BaseItemDetail/LineItemNum}\">\r\n"
    		+ "                            <ItemID>\r\n"
    		+ "                                <SupplierPartID>\r\n"
    		+ "                                    <xsl:value-of select=\"BaseItemDetail/SupplierPartNum/PartNum/PartID\"/>\r\n"
    		+ "                                </SupplierPartID>\r\n"
    		+ "                                <SupplierPartAuxiliaryID>\r\n"
    		+ "                                    <xsl:value-of select=\"BaseItemDetail/SupplierPartNum/PartNum/PartIDExt\"/>\r\n"
    		+ "                                </SupplierPartAuxiliaryID>\r\n"
    		+ "                            </ItemID>\r\n"
    		+ "                            <ItemDetail>\r\n"
    		+ "                                <UnitPrice>\r\n"
    		+ "                                    <Money>\r\n"
    		+ "                                        <xsl:value-of select=\"BuyerExpectedUnitPrice/Price/UnitPrice\"/>\r\n"
    		+ "                                    </Money>\r\n"
    		+ "                                </UnitPrice>\r\n"
    		+ "                                <Description xml:lang=\"en\">\r\n"
    		+ "                                    <xsl:value-of select=\"BaseItemDetail/ItemDescription\"/>\r\n"
    		+ "                                </Description>\r\n"
    		+ "                                <UnitOfMeasure>\r\n"
    		+ "                                    <xsl:value-of select=\"BaseItemDetail/Quantity/UnitOfMeasure/UOM\"/>\r\n"
    		+ "                                </UnitOfMeasure>\r\n"
    		+ "                            </ItemDetail>\r\n"
    		+ "                            <ShipTo>\r\n"
    		+ "                                <Address>\r\n"
    		+ "                                    <PostalAddress>\r\n"
    		+ "                                        <DeliverTo>\r\n"
    		+ "                                            <xsl:value-of select=\"BaseItemDetail/FinalRecipient/Party/OrderContact/Contact/ContactName\"/>\r\n"
    		+ "                                        </DeliverTo>\r\n"
    		+ "                                        <Country>\r\n"
    		+ "                                            <xsl:value-of select=\"BaseItemDetail/FinalRecipient/Party/NameAddress/Country\"/>\r\n"
    		+ "                                        </Country>\r\n"
    		+ "                                    </PostalAddress>\r\n"
    		+ "                                    <Email>\r\n"
    		+ "                                        <xsl:value-of select=\"BaseItemDetail/FinalRecipient/Party/OrderContact/Contact/Email\"/>\r\n"
    		+ "                                    </Email>\r\n"
    		+ "                                    <Phone>\r\n"
    		+ "                                        <TelephoneNumber>\r\n"
    		+ "                                            <CountryCode>\r\n"
    		+ "                                                <xsl:value-of select=\"BaseItemDetail/FinalRecipient/Party/NameAddress/Country\"/>\r\n"
    		+ "                                            </CountryCode>\r\n"
    		+ "                                        </TelephoneNumber>\r\n"
    		+ "                                    </Phone>\r\n"
    		+ "                                </Address>\r\n"
    		+ "                            </ShipTo>\r\n"
    		+ "                        </ItemOut>\r\n"
    		+ "                    </xsl:for-each>\r\n"
    		+ "                </OrderRequest>\r\n"
    		+ "            </Request>\r\n"
    		+ "        </cXML>\r\n"
    		+ "    </xsl:template>\r\n"
    		+ "</xsl:stylesheet>\r\n"
    		+ "";

	
	
	public static String xslt_ciw = "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\r\n"
			+ "    <xsl:output method=\"xml\" indent=\"yes\"/>\r\n"
			+ "    \r\n"
			+ "    <xsl:template match=\"/\">\r\n"
			+ "        <PurchaseOrder>\r\n"
			+ "            <account_name>\r\n"
			+ "                <xsl:value-of select=\"PurchaseOrder/OrderParty/BuyerParty/Party/NameAddress/Name3\"/>\r\n"
			+ "            </account_name>\r\n"
			+ "            <Routing>\r\n"
			+ "                <SenderID>\r\n"
			+ "                    <xsl:value-of select=\"PurchaseOrder/OrderParty/BuyerParty/Party/NameAddress/Name3\"/>\r\n"
			+ "                </SenderID>\r\n"
			+ "            </Routing>\r\n"
			+ "            <Header>\r\n"
			+ "                <po_number>\r\n"
			+ "                    <xsl:value-of select=\"PurchaseOrder/OrderReference/BuyerRefNum/Reference/RefNum\"/>\r\n"
			+ "                </po_number>\r\n"
			+ "                <po_date>\r\n"
			+ "                    <xsl:value-of select=\"PurchaseOrder/OrderHeader/POIssuedDate\"/>\r\n"
			+ "                </po_date>\r\n"
			+ "                <requested_ship_date>\r\n"
			+ "                    <xsl:value-of select=\"PurchaseOrder/OrderHeader/ShipByDate\"/>\r\n"
			+ "                </requested_ship_date>\r\n"
			+ "                <HeaderCustom>\r\n"
			+ "                    <custom_value>\r\n"
			+ "                        <xsl:value-of select=\"PurchaseOrder/OrderHeader/VendorInformation/InternalVendorNumber\"/>\r\n"
			+ "                    </custom_value>\r\n"
			+ "                </HeaderCustom>\r\n"
			+ "                <HeaderCustom>\r\n"
			+ "                    <custom_value>\r\n"
			+ "                        <xsl:value-of select=\"PurchaseOrder/OrderReference/SupplierRefNum/Reference/RefNum\"/>\r\n"
			+ "                    </custom_value>\r\n"
			+ "                </HeaderCustom>\r\n"
			+ "                <HeaderCustom>\r\n"
			+ "                    <custom_value>\r\n"
			+ "                        <xsl:value-of select=\"PurchaseOrder/OrderHeader/POIssuedDate\"/>\r\n"
			+ "                    </custom_value>\r\n"
			+ "                </HeaderCustom>\r\n"
			+ "                <HeaderAddress>\r\n"
			+ "                    <address_type>ST</address_type>\r\n"
			+ "                    <address_name>\r\n"
			+ "                        <xsl:value-of select=\"PurchaseOrder/OrderParty/ShipToParty/Party/NameAddress/Name1\"/>\r\n"
			+ "                    </address_name>\r\n"
			+ "                    <address_line_1>\r\n"
			+ "                        <xsl:value-of select=\"PurchaseOrder/OrderParty/ShipToParty/Party/NameAddress/Address1\"/>\r\n"
			+ "                    </address_line_1>\r\n"
			+ "                    <address_city>\r\n"
			+ "                        <xsl:value-of select=\"PurchaseOrder/OrderParty/ShipToParty/Party/NameAddress/City\"/>\r\n"
			+ "                    </address_city>\r\n"
			+ "                    <address_state>\r\n"
			+ "                        <xsl:value-of select=\"PurchaseOrder/OrderParty/ShipToParty/Party/NameAddress/StateOrProvince\"/>\r\n"
			+ "                    </address_state>\r\n"
			+ "                    <address_zip>\r\n"
			+ "                        <xsl:value-of select=\"PurchaseOrder/OrderParty/ShipToParty/Party/NameAddress/PostalCode\"/>\r\n"
			+ "                    </address_zip>\r\n"
			+ "                    <HeaderAddressContact>\r\n"
			+ "                        <contact_phone>\r\n"
			+ "                            <xsl:value-of select=\"PurchaseOrder/OrderParty/ShipToParty/Party/OrderContact/Contact/Telephone\"/>\r\n"
			+ "                        </contact_phone>\r\n"
			+ "                        <contact_email>\r\n"
			+ "                            <xsl:value-of select=\"PurchaseOrder/OrderParty/ShipToParty/Party/OrderContact/Contact/Email\"/>\r\n"
			+ "                        </contact_email>\r\n"
			+ "                    </HeaderAddressContact>\r\n"
			+ "                </HeaderAddress>\r\n"
			+ "            </Header>\r\n"
			+ "            <xsl:for-each select=\"PurchaseOrder/ListOfOrderDetail/OrderDetail\">\r\n"
			+ "                <Detail>\r\n"
			+ "                    <po_line_number>\r\n"
			+ "                        <xsl:value-of select=\"BaseItemDetail/LineItemNum\"/>\r\n"
			+ "                    </po_line_number>\r\n"
			+ "                    <qty_ordered>\r\n"
			+ "                        <xsl:value-of select=\"BaseItemDetail/Quantity/Qty\"/>\r\n"
			+ "                    </qty_ordered>\r\n"
			+ "                    <unit_price>\r\n"
			+ "                        <xsl:value-of select=\"BuyerExpectedUnitPrice/Price/UnitPrice\"/>\r\n"
			+ "                    </unit_price>\r\n"
			+ "                    <customer_item_number>\r\n"
			+ "                        <xsl:value-of select=\"BaseItemDetail/ManufacturerPartNum/PartNum/PartID\"/>\r\n"
			+ "                    </customer_item_number>\r\n"
			+ "                    <requested_ship_date>\r\n"
			+ "                        <xsl:value-of select=\"BaseItemDetail/ShipByDate\"/>\r\n"
			+ "                    </requested_ship_date>\r\n"
			+ "                    <DetailDescription>\r\n"
			+ "                        <descr>\r\n"
			+ "                            <xsl:value-of select=\"BaseItemDetail/ItemDescription\"/>\r\n"
			+ "                        </descr>\r\n"
			+ "                    </DetailDescription>\r\n"
			+ "                </Detail>\r\n"
			+ "            </xsl:for-each>\r\n"
			+ "        </PurchaseOrder>\r\n"
			+ "    </xsl:template>\r\n"
			+ "</xsl:stylesheet>\r\n"
			+ "";

}
