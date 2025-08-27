import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper

// GET LIST USERS
def responseList = WS.sendRequest(findTestObject('GET_ListUsers'))
WS.verifyResponseStatusCode(responseList, 200)

def jsonList = new JsonSlurper().parseText(responseList.getResponseBodyContent())
def userId = jsonList.data[0].id   
println("User ID dari List Users: " + userId)

// Simpan ke GlobalVariable
GlobalVariable.userId = userId


// GET SINGLE USER
def responseSingle = WS.sendRequest(findTestObject('GET_SingleUser', [('userId') : GlobalVariable.userId]))
WS.verifyResponseStatusCode(responseSingle, 200)

def jsonSingle = new JsonSlurper().parseText(responseSingle.getResponseBodyContent())
def userEmail = jsonSingle.data.email
println("Email dari Single User: " + userEmail)

// Simpan email ke GlobalVariable
GlobalVariable.userEmail = userEmail
