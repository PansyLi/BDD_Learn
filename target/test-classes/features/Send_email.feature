Feature:Send email
  Customer can send email use 163 mail
  Scenario: Email send successfully
    Given Customer login 163 mail successfully
    When Customer write an email and click send button
    Then Email send successfully