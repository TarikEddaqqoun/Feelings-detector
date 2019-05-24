# Feelings detector

Feeling detector is a web service using IBM watson tone analyzer to analyze mood from text.

The request sould be GET request where the header has a parameter 'api-key' with the api key from IBM Cloud platform, and the body contains the text to analyze.

Example of GET request :

   
    header:{
      'api-key':{Your API key}
    }
    body:{
        "I'm feeling down about work lately"
    }
