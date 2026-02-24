using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using FMODUnity;

public class SpatialAudioController : MonoBehaviour
{
    [EventRef]
    public string fmodEvent;
    private FMOD.Studio.EventInstance eventInstance;
    void Start()
    {
        eventInstance = RuntimeManager.CreateInstance(fmodEvent);
        RuntimeManager.AttachInstanceToGameObject(eventInstance, transform, GetComponent<Rigidbody>());
        eventInstance.start();
    }
    void Update()
    {
        // Update the position of the audio source based on the game object
        Vector3 position = transform.position;
        eventInstance.set3DAttributes(RuntimeUtils.To3DAttributes(position));
    }
    private void OnDestroy()
    {
        eventInstance.stop(FMOD.Studio.STOP_MODE.ALLOWFADEOUT);
        eventInstance.release();
    }
}

