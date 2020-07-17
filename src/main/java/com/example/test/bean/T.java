/*
select * from(SELECT
    i.busi_no,
    i.busi_acc_mng_pers_id,
    i.busi_cur_dealw_inst_no,
    b.prodt_no,
    to_char(b.apply_date,'yy-mm-dd')apply_date,
    b.busi_status,
    b.apply_amt,
    bf.loan_dirc_code,
    p.cust_cert_no,
    p.cust_cert_type,
    p.cust_name,
    b.cust_id,
    i.prov_code
FROM
    t_lin_org_info i
inner join t_lin_bapl_hist b on b.busi_no=i.busi_no
LEFT JOIN t_lin_bapl_inf bf ON bf.busi_no=i.busi_no
LEFT JOIN cm_cus_personal p ON p.cust_id=b.cust_id
WHERE
i.busi_acc_mng_pers_id=#[outPersonNo]
AND i.prov_code=#[provCode]
and i.busi_cur_dealw_inst_no=#[instNo]
and p.data_source_type=#[dataSourceType]
<if test="busiStatus!=null and busiStatus!="">and b.busistatus=#[busiStatus]</if>
<if test="custName!=null and custName!="">and p.cust_name=#{custName}</if>
<if test="custCertType!=null and custCertType!="">and p.cust_cert_type=#{custCertType}</if>
<if test="custCertNo!=null and custCertNo!="">and p.cust_certno=#{custCertNo}</if>
UNION ALL
SELECT
w.loan_apply_idasbusi_no,
w.create_tellernoasbusiacc_mng_pers_id,
w.create_inst_noasbusi_cur_dealw_inst_no,
null,
to_char(w.createtime,'yy-mm-dd')apply_date,
null,
w.apply_limit_amtasapply_amt,
w.loan_usage_descasloan__dirc_code,
p.cust_cert_no,
p.cust_cert_type,
p.cust_name,
w.custid,
w.prov_code
FROM
t_lon_weichat_loan_info w
left join
cm_cus_personal p
on p.cust_id=w.cust_id
WHERE
w.prov_code=#[provCode]
and w.create_teller_no=#[outPersonNo]
and w.create_inst_no=#[instNo]
and p.datasource_type=#(dataSourceType]and
NOT EXISTS(
    SELECT
    1
    FROM
    t_lin_bapl_hist b,
    t_lin_org_info i
    WHERE
    b.busi_no=i.busi_no
    AND w.cust_id=b.cust_id
    AND i.busi_acc_mng_pers_id=#{outPersonNo}
        )
<if test="busiStatus!=null and busiStatus!=""">and b.busi_status=#(busiStatus]</if>
<if test="custName!=null and custName!=""">andp.cust_name=#(custName]</if>
<if test="custCertType!=null and custCertType!=""">and p.custcert_type=#(custCertType]</if>
<if test="custCertNo!=null and custCertNo!=""">and p.custcert_no=#(custCertNo]</if>
        )a*/
