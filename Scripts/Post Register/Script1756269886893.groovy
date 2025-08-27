import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper

def responseRegister = WS.sendRequest(findTestObject('POST_Register', 
    [('userEmail') : GlobalVariable.userEmail]))

WS.verifyResponseStatusCode(responseRegister, 200)

def jsonReg = new JsonSlurper().parseText(responseRegister.getResponseBodyContent())
println("Register Success -> ID: " + jsonReg.id + ", Token: " + jsonReg.token)
