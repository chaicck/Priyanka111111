package demo.objectrepository;

public interface OR_DNSRecords {

    String firstDeleteLnk ="xpath=(//table[@id='dns_table']/tbody//a[@class='dnsDelete'])[1]";
    String viewOrEdit ="xpath=(//a[@title='View/Edit'])[1]";
    String addDnsEntryLnk ="xpath=//a[contains(@href,'/dns/add/')]";
    String totalDnsRecords="xpath=//table[@id='dns_table']/tbody/tr";
    String nameToVerify="xpath=(//table[@id='dns_table']/tbody/tr/td[3])[%s]";
}
